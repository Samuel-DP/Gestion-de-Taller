package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Inventario;

public class InventarioDao {

    public void insertar(Inventario inventario){
        String sql = "INSERT INTO inventario (nombre_producto, cantidad, precio_unitario, id_proveedor) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConexionDB.conectar(); 
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inventario.getNombreProducto());
            statement.setInt(2, inventario.getCantidad());
            statement.setDouble(3, inventario.getPrecioUnitario());
            statement.setInt(4, inventario.getIdProveedor());
            statement.executeUpdate();
            System.out.println("Producto insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(String nombreProducto) {
        String sql = "DELETE FROM inventario WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreProducto);
            statement.executeUpdate();
            if (statement.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún producto con el nombre proporcionado.");
                return;
            }
            System.out.println("Producto eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean  obtenerPorNombre(String nombreProducto) {
        String sql = "SELECT * FROM inventario WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreProducto);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Producto encontrado: ");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void actualizarNombre(String nombreProducto, String nuevoNombre) {
        String sql = "UPDATE inventario SET nombre_producto = ? WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nombreProducto);
            statement.executeUpdate();
            if (statement.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún producto con el nombre proporcionado.");
                return;
            }
            System.out.println("Nombre del producto actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCantidad(String nombreProducto, int nuevaCantidad) {
        String sql = "UPDATE inventario SET cantidad = ? WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, nuevaCantidad);
            statement.setString(2, nombreProducto);
            statement.executeUpdate();
            if (statement.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún producto con el nombre proporcionado.");
                return;
            }
            System.out.println("Cantidad del producto actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPrecioUnitario(String nombreProducto, double nuevoPrecio) {
        String sql = "UPDATE inventario SET precio_unitario = ? WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, nuevoPrecio);
            statement.setString(2, nombreProducto);
            statement.executeUpdate();
            if (statement.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún producto con el nombre proporcionado.");
                return;
            }
            System.out.println("Precio unitario del producto actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Inventario> obtenerTodos() {
        ArrayList<Inventario> inventarios = new ArrayList<>();
        String sql = "SELECT * FROM inventario";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Inventario inventario = new Inventario(
                    resultSet.getString("nombre_producto"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precio_unitario"),
                    resultSet.getInt("id_proveedor") 
                );
                inventarios.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventarios;
    }
}

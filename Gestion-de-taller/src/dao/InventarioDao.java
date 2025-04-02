package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Inventario;

public class InventarioDao {

    public void insertar(Inventario inventario){
        String sql = "INSERT INTO inventario (nombre_producto, cantidad, precio_unitario) VALUES (?, ?, ?)";
        try (Connection connection = ConexionDB.conectar(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, inventario.getNombreProducto());
            statement.setInt(2, inventario.getCantidad());
            statement.setDouble(3, inventario.getPrecioUnitario());
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

    public void obtenerPorNombre(String nombreProducto) {
        String sql = "SELECT * FROM inventario WHERE nombre_producto = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreProducto);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Producto encontrado: " + resultSet.getString("nombre_producto"));
            } else {
                System.out.println("No se encontró ningún producto con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

}

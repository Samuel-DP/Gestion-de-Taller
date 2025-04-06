package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Proveedores;

public class ProveedoresDao {
    
    public void insertar(Proveedores proveedores) {
        String sql = "INSERT INTO proveedores (nombre, telefono, direccion, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedores.getNombre());
            statement.setString(2, proveedores.getTelefono());
            statement.setString(3, proveedores.getDireccion());
            statement.setString(4, proveedores.getEmail());
            statement.executeUpdate();

            System.out.println("Proveedor insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void eliminarProveedor(String nombre) {
        String sql = "DELETE FROM proveedores WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Proveedor eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proveedores obtenerPorNombre(String nombre) {
        String sql = "SELECT * FROM proveedores WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Proveedores(
                    resultSet.getString("nombre"),
                    resultSet.getString("telefono"),
                    resultSet.getString("direccion"),
                    resultSet.getString("email")
                );
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarNombre(String nombre, String nuevoNombre) {
        String sql = "UPDATE proveedores SET nombre = ? WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nombre);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nombre del proveedor actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarTelefono(String nombre, String nuevoTelefono) {
        String sql = "UPDATE proveedores SET telefono = ? WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoTelefono);
            statement.setString(2, nombre);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Teléfono del proveedor actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarDireccion(String nombre, String nuevaDireccion) {
        String sql = "UPDATE proveedores SET direccion = ? WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevaDireccion);
            statement.setString(2, nombre);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dirección del proveedor actualizada correctamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmail(String nombre, String nuevoEmail) {
        String sql = "UPDATE proveedores SET email = ? WHERE nombre = ?";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoEmail);
            statement.setString(2, nombre);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Email del proveedor actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el nombre proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Proveedores> obtenerTodos() {
        ArrayList<Proveedores> listaProveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Connection connection = ConexionDB.conectar();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Proveedores proveedor = new Proveedores(
                    resultSet.getString("nombre"),
                    resultSet.getString("telefono"),
                    resultSet.getString("direccion"),
                    resultSet.getString("email")
                );
                listaProveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProveedores;
    }
}

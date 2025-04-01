package dao;

import java.sql.*;

public class ConsultaDB {
    public static void obtenerClientes() {
        // Establecer conexión
        Connection conexion = ConexionDB.conectar();
        
        if (conexion != null) {
            // Consulta SQL para obtener todos los clientes
            String query = "SELECT * FROM clientes";
            try (Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                // Iterar sobre los resultados
                while (rs.next()) {
                System.out.println("ID: " +
                rs.getInt("id_cliente"));
                System.out.println("Nombre: " +
                rs.getString("nombre"));
                System.out.println("Teléfono: " +
                rs.getString("telefono"));
                System.out.println("Dirección: " +
                rs.getString("direccion"));
                System.out.println("----------------------");
                }
            } catch (SQLException e) {
                System.out.println("Error al realizar la consulta: " + e.getMessage());
            }
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Servicio;

public class ServicioDao {

    public void insertar(Servicio servicio) {
        String sql = "INSERT INTO servicios (descripcion, precio, horas) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servicio.getDescripcion());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setDouble(3, servicio.getHoras());

            stmt.executeUpdate();
            System.out.println("Servicio insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPrecio(String descripcion, double precio) {
        String sql = "UPDATE servicios SET precio = ? WHERE descripcion = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, precio);
            stmt.setString(2, descripcion);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún servicio con la descripción proporcionada.");
                return;
            }
            System.out.println("Precio actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarHoras(String descripcion, double horas) {
        String sql = "UPDATE servicios SET horas = ? WHERE descripcion = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, horas);
            stmt.setString(2, descripcion);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún servicio con la descripción proporcionada.");
                return;
            }
            System.out.println("Horas actualizadas correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarDescripcion(String descripcionActual, String nuevaDescripcion) {
        String sql = "UPDATE servicios SET descripcion = ? WHERE descripcion = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuevaDescripcion);
            stmt.setString(2, descripcionActual);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún servicio con la descripción proporcionada.");
                return;
            }
            System.out.println("Descripción actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(String descripcion) {
        String sql = "DELETE FROM servicios WHERE descripcion = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, descripcion);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún servicio con la descripción proporcionada.");
                return;
            }
            System.out.println("Servicio eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Servicio> obtenerTodos() {
        ArrayList<Servicio> servicios = new ArrayList<>();
        String sql = "SELECT * FROM servicios";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                double horas = rs.getDouble("horas");

                Servicio servicio = new Servicio(descripcion, precio, horas);
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicios;
    }

    public Servicio obtenerPorDescripcion(String descripcion) {
        String sql = "SELECT * FROM servicios WHERE descripcion = ?";
        Servicio servicio = null;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, descripcion);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double precio = rs.getDouble("precio");
                double horas = rs.getDouble("horas");

                servicio = new Servicio(descripcion, precio, horas);
            } else {
                System.out.println("No se encontró ningún servicio con la descripción proporcionada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicio;
    }
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Citas;

public class CitasDao {
    public void insertar(Citas cita) {
        String sql = "INSERT INTO citas (fecha, hora, clienteDni, vehiculoMatricula, descripcion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cita.getFecha());
            stmt.setString(2, cita.getHora());
            stmt.setString(3, cita.getClienteDni());
            stmt.setString(4, cita.getVehiculoMatricula());
            stmt.setString(5, cita.getDescripcion());
            stmt.setString(6, cita.getEstado());

            stmt.executeUpdate();
            System.out.println("Cita insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarEstado(String dniCliente, String nuevoEstado) {
        String sql = "UPDATE citas SET estado = ? WHERE clienteDni = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nuevoEstado);
            stmt.setString(2, dniCliente);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Estado actualizado correctamente.");
            } else {
                System.out.println("No se encontró ninguna cita con el DNI proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Citas> obtenerTodas() {
        
        ArrayList<Citas> listaCitas = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String clienteDni = rs.getString("clienteDni");
                String vehiculoMatricula = rs.getString("vehiculoMatricula");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");

                Citas cita = new Citas(fecha, hora, clienteDni, vehiculoMatricula, descripcion, estado);
                listaCitas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCitas;
    }

    public Citas obtenerPorDni(String dniCliente) {
        String sql = "SELECT * FROM citas WHERE clienteDni = ?";
        Citas cita = null;
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dniCliente);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {

                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String clienteDni = rs.getString("clienteDni");
                String vehiculoMatricula = rs.getString("vehiculoMatricula");
                String descripcion = rs.getString("descripcion");
                String estado = rs.getString("estado");

                cita = new Citas(fecha, hora, clienteDni, vehiculoMatricula, descripcion, estado);
                
            }
            else {
                System.out.println("No se encontró ninguna cita con el DNI proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    public Citas obtenerPorMatricula(String matriculaVehiculo) {
        String sql = "SELECT * FROM citas WHERE vehiculoMatricula = ?";
        Citas cita = null;
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, matriculaVehiculo);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                    String fecha = rs.getString("fecha");
                    String hora = rs.getString("hora");
                    String clienteDni = rs.getString("clienteDni");
                    String vehiculoMatricula = rs.getString("vehiculoMatricula");
                    String descripcion = rs.getString("descripcion");
                    String estado = rs.getString("estado");

                    cita = new Citas(fecha, hora, clienteDni, vehiculoMatricula, descripcion, estado);
                
            }
            else {
                System.out.println("No se encontró ninguna cita con la matrícula proporcionada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    public void eliminar(String dniCliente) {
        String sql = "DELETE FROM citas WHERE clienteDni = ?";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dniCliente);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Cita eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna cita con el DNI proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
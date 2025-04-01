package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;

public class ClientesDao{
    public void insertar(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, Apellido, Dni, telefono) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDni());
            stmt.setInt(3, cliente.getTelefono());

            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarNombre(String dni, String nombre) {
        String sql = "UPDATE clientes SET nombre = ? WHERE dni = ?";
            
    try (Connection conn = ConexionDB.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, nombre);
        stmt.setString(2, dni);
        stmt.executeUpdate();
            System.out.println("Nombre actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void ActualizarApellido(String dni, String apellido) {
        String sql = "UPDATE clientes SET apellido = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, apellido);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            System.out.println("Apellido actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarDni(String dniActual, String nuevoDni) {
        String sql = "UPDATE clientes SET dni = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nuevoDni);
            stmt.setString(2, dniActual);
            stmt.executeUpdate();
            System.out.println("DNI actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActualizarTelefono(String dni, int telefono) {
        String sql = "UPDATE clientes SET telefono = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, telefono);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            System.out.println("Teléfono actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(String dni) {
        String sql = "DELETE FROM clientes WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dni);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> obtenerTodos(){ 
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                int telefono = rs.getInt("telefono");
                
                Cliente cliente = new Cliente(nombre, apellido, dni, telefono);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }

    public Cliente obtenerPorDni(String dni) {
        String sql = "SELECT * FROM clientes WHERE dni = ?";
        Cliente cliente = null;
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int telefono = rs.getInt("telefono");
                
                cliente = new Cliente(nombre, apellido, dni, telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cliente;
    }

}


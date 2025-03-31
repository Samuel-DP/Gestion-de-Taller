
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;

public class ClientesDao{
    public void insertar(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, Apellido, Dni, telefono) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDni());
            stmt.setString(3, cliente.getTelefono());

            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(int id_cliente){
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id_cliente);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }
    public Cliente buscarPorId(int id_cliente){
        
     }
    public ArrayList<Cliente> obtenerTodos(){ 

    }

}
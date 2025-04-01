package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Empleado;


public class EmpleadoDao {
    
    public void insertar(Empleado empleado){
        String sql = "INSERT INTO empleados (nombre, apellidos, dni, puesto, salario) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getDni());
            stmt.setString(4, empleado.getPuesto());
            stmt.setDouble(5, empleado.getSalario());

            stmt.executeUpdate();
            System.out.println("Empleado insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(String dniEmpleado) {
        String sql = "DELETE FROM empleados WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dniEmpleado);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("Empleado eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarNombre(String dni, String nombre) {
        String sql = "UPDATE empleados SET nombre = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("Nombre actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarApellido(String dni, String apellido) {
        String sql = "UPDATE empleados SET apellidos = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, apellido);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("Apellido actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPuesto(String dni, String puesto) {
        String sql = "UPDATE empleados SET puesto = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, puesto);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("Puesto actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSalario(String dni, double salario) {
        String sql = "UPDATE empleados SET salario = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, salario);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("Salario actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarDni(String dniActual, String nuevoDni) {
        String sql = "UPDATE empleados SET dni = ? WHERE dni = ?";
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nuevoDni);
            stmt.setString(2, dniActual);
            stmt.executeUpdate();
            if (stmt.getUpdateCount() == 0) {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
                return;
            }
            System.out.println("DNI actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> obtenerTodos() {
        String sql = "SELECT * FROM empleados";
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String puesto = rs.getString("puesto");
                double salario = rs.getDouble("salario");
                
                Empleado empleado = new Empleado(nombre, apellidos, dni, puesto, salario);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empleados;
    }

    public Empleado obtenerPorDni(String dni) {
        String sql = "SELECT * FROM empleados WHERE dni = ?";
        Empleado empleado = null;
        
        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String puesto = rs.getString("puesto");
                double salario = rs.getDouble("salario");
                
                empleado = new Empleado(nombre, apellidos, dni, puesto, salario);
            }else {
                System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return empleado;
    }

}

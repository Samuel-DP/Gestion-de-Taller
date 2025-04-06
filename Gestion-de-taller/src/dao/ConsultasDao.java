package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultasDao {

    public void mostrarVehiculosConClientes() {
        String sql = """
            SELECT v.matricula, v.marca, v.modelo, c.nombre, c.apellido
            FROM vehiculos v
            JOIN clientes c ON v.id_cliente = c.id_cliente;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Vehículos y propietarios:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println("Matrícula: " + rs.getString("matricula") +
                                ", Marca: " + rs.getString("marca") +
                                ", Modelo: " + rs.getString("modelo") +
                                ", Cliente: " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientesConMenosDe30000Km() {
        String sql = """
            SELECT c.nombre, c.apellido, v.km
            FROM clientes c
            JOIN vehiculos v ON c.id_cliente = v.id_cliente
            WHERE v.km < 30000;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Clientes con vehículos de menos de 30000 km:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + 
                                " " +rs.getString("apellido") +
                                ", Km: " + rs.getInt("km"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cocheAnteriores2020(){
        String sql = """
            SELECT c.nombre, c.apellido, v.marca, v.modelo, v.año
            FROM clientes c
            JOIN vehiculos v ON c.id_cliente = v.id_cliente
            WHERE v.año < 2020;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Clientes con vehículos anteriores a 2020:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + 
                                " " +rs.getString("apellido") +
                                ", Marca: " + rs.getString("marca") +
                                ", Modelo: " + rs.getString("modelo") +
                                ", Año: " + rs.getInt("año"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
public void mostrarProductosConProveedores() {
        String sql = """
            SELECT i.nombre_producto, p.nombre
            FROM inventario i
            JOIN proveedores p ON i.id_proveedor = p.id_proveedor;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Productos y proveedores:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println("Producto: " + rs.getString("nombre_producto") +
                                ", Proveedor: " + rs.getString("nombre"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void mostrarProductosConPrecioMayorA50() {
        String sql = """
            SELECT i.nombre_producto, i.precio_unitario
            FROM inventario i
            WHERE i.precio_unitario > 50;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Productos con precio mayor a 50 euros:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println("Producto: " + rs.getString("nombre_producto") +
                                ", Precio: " + rs.getDouble("precio_unitario"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void mostrarEmpleadosConSalarioMayorA2500(){
        String sql = """
            SELECT e.nombre, e.apellido, e.salario
            FROM empleados e
            WHERE e.salario > 2500;""";

        try (Connection conn = ConexionDB.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Empleados con salario mayor a 2500 euros:");
            System.out.println("                                         ");
            System.out.println("=========================================");
            System.out.println("                                         ");
            while (rs.next()) {
                System.out.println("Empleado: " + rs.getString("nombre") +
                                " " + rs.getString("apellido") +
                                ", Salario: " + rs.getDouble("salario"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

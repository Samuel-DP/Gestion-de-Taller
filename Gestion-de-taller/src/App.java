import dao.ConexionDB;
import java.sql.Connection;
import java.util.Scanner;
import view.CitasView;
import view.ClienteView;
import view.ConsultasView;
import view.EmpleadoView;
import view.InventarioView;
import view.ProveedoresView;
import view.ServicioView;
import view.VehiculoView;


public class App {
    public static void main(String[] args) throws Exception {

        Connection conexion = ConexionDB.conectar();
        if (conexion != null) {
        System.out.println("Conexión establecida correctamente.");
        } else {
        System.out.println("No se pudo establecer la conexión.");
        }

        Scanner scanner = new Scanner(System.in);
        ClienteView cliente = new ClienteView();
        EmpleadoView empleado = new EmpleadoView();
        VehiculoView vehiculo = new VehiculoView();
        InventarioView inventario = new InventarioView();
        ProveedoresView proveedores = new ProveedoresView();
        CitasView cita = new CitasView();
        ConsultasView consultas = new ConsultasView();
        ServicioView servicio = new ServicioView();


        int opcion;
        do{ 

            System.out.println("\nGestion de taller");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Gestionar cliente");
            System.out.println("3. Registrar vehiculo");
            System.out.println("4. Gestionar vehiculo");
            System.out.println("5. Registrar empleado");
            System.out.println("6. Gestionar empleado");
            System.out.println("7. Crear servicio");
            System.out.println("8. Actualizar servicio");
            System.out.println("9. Gestion de inventario");
            System.out.println("10. Gestionar proveedores");
            System.out.println("11. Crear cita");
            System.out.println("12. Gestionar cita");
            System.out.println("13. Consultar datos");
            System.out.println("14. Salir");
            System.out.println("Selecciona una opcion: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                
                case 1 -> cliente.crearCliente();
                case 2 -> cliente.gestionarCliente();
                case 3 -> vehiculo.crearVehiculo();
                case 4 -> vehiculo.gestionarVehiculo();
                case 5 -> empleado.crearEmpleado();
                case 6 -> empleado.gestionarEmpleado();  
                case 7-> servicio.crearServicio();
                case 8 -> servicio.actualizarServicio();
                case 9 -> inventario.gestionInventario();         
                case 10 ->proveedores.gestionProveedores();          
                case 11 -> cita.crearCita(); 
                case 12 -> cita.gestionarCita();  
                case 13 -> consultas.Consultas();              
                case 14 -> System.out.println("Saliendo del programa");   
                default -> System.out.println("Opción no válida, intente nuevamente.");        
            }   
        }while(opcion != 14);
        scanner.close();
    }
}



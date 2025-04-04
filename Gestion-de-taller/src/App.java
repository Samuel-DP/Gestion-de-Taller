import dao.ConexionDB;
import java.sql.Connection;
import java.util.Scanner;
//import view.CitasView;
import view.ClienteView;
import view.EmpleadoView;
import view.InventarioView;
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
        //CitasView cita = new CitasView();

        int opcion;
        do{ 

        System.out.println("\nGestion de taller");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Gestionar cliente");
        System.out.println("3. Registrar vehiculo");
        System.out.println("4. Gestionar vehiculo");
        System.out.println("5. Crear servicio");
        System.out.println("6. Registrar empleado");
        System.out.println("7. Gestionar empleado");
        System.out.println("8. Asignar servicio");
        System.out.println("9. Gestion de inventario");
        System.out.println("10. Realizar pedidos");
        System.out.println("11. Consultar datos");
        System.out.println("13. Salir");
        System.out.println("Selecciona una opcion: ");
        
        opcion = scanner.nextInt();

        
        switch (opcion) {
            
            case 1 -> cliente.crearCliente();
            case 2 -> cliente.gestionarCliente();
            case 3 -> vehiculo.crearVehiculo();
            case 4 -> vehiculo.gestionarVehiculo();
            //case 5 -> taller.crearServicio();
            case 6 -> empleado.crearEmpleado(); 
            case 7 -> empleado.gestionarEmpleado();
            //case 6 -> taller.asignarServicio();   
           // case 7 -> taller.gestionInventario();   
            case 9 -> inventario.gestionInventario();         
           // case 7 -> taller.gestionInventario(); 
           // case 8 -> cita.crearCita(); 
            //case 10 -> cita.gestionarCita();                 
            case 13 -> System.out.println("Saliendo del programa");   
            case 8 -> cita.crearCita(); 
            case 11 -> cita.gestionarCita();                 
            case 10 -> System.out.println("Saliendo del programa");   
            default -> System.out.println("Opción no válida, intente nuevamente.");        
        }   
            
        }while(opcion != 13);
    }
}



import dao.ConexionBD;
import java.sql.Connection;
import java.util.Scanner;
import view.ClienteView;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ClienteView cliente = new ClienteView();
        Taller taller = new Taller();
        int opcion;

        do{ 

        System.out.println("\nGestion de taller");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Gestionar cliente");
        System.out.println("3. Registrar vehiculo");
        System.out.println("4. Crear servicio");
        System.out.println("5. Crear empleado");
        System.out.println("6. Asignar servicio");
        System.out.println("7. Gestion de inventario");
        System.out.println("");
        System.out.println("8");
        System.out.println("9. Salir");
        System.out.println("Selecciona una opcion: ");
        
        opcion = scanner.nextInt();

        
        switch (opcion) {
            case 1 -> cliente.crearCliente();
            case 2 -> cliente.gestionarCliente();
            case 3 -> taller.crearVehiculo();
            case 4 -> taller.crearServicio();
            case 5 -> taller.crearEmpleado(); 
            case 6 -> taller.asignarServicio();   
           // case 7 -> taller.gestionInventario();         
            case 9 -> System.out.println("Saliendo del programa");   
            default -> System.out.println("Opción no válida, intente nuevamente.");        
        }   
            
        }while(opcion != 9);


        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
        System.out.println("Conexión establecida correctamente.");
        } else {
        System.out.println("No se pudo establecer la conexión.");
        }
    
        
        
    }
}



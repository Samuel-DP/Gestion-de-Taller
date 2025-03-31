import dao.ConexionBD;
import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do{ 
        Taller taller = new Taller();
        System.out.println("Gestion de taller");
        System.out.println("1. Registrar cliente");
        System.out.println("1. Gestionar cliente");
        System.out.println("2. Registrar vehiculo");
        System.out.println("3. Crear servicio");
        System.out.println("4. Crear empleado");
        System.out.println("5. Asignar servicio");
        System.out.println("6. Gestion de inventario");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9. Salir");
        System.out.println("Selecciona una opcion: ");
        
        opcion = scanner.nextInt();

        
        switch (opcion) {
            case 1 -> taller.crearCliente();
            case 2 -> taller.crearVehiculo();
            case 3 -> taller.crearServicio();
            case 4 -> taller.crearEmpleado(); 
            case 5 -> taller.asignarServicio();   
                 
            case 9 -> System.out.println("Saliendo del programa");   
            default -> System.out.println("Opción no válida, intente nuevamente.");        
        }   
            
        }while(opcion != 9);


        System.out.println("Hola");

        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
        System.out.println("Conexión establecida correctamente.");
        } else {
        System.out.println("No se pudo establecer la conexión.");
        }
    
        
        
    }
}



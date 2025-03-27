import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do{ 
        Taller taller = new Taller();
        System.out.println("Gestion de taller");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar vehiculo");
        System.out.println("3. Crear servicio");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("8. Salir");
        System.out.println("Selecciona una opcion: ");
        
        opcion = scanner.nextInt();

        
        switch (opcion) {
            case 1 -> taller.crearCliente();
            case 2 -> taller.crearVehiculo();
            case 3 -> taller.crearServicio();
            case 8 -> System.out.println("Saliendo del programa");   
            default -> System.out.println("Opción no válida, intente nuevamente.");        
        }   
            
        }while(opcion != 8);
        
        
    }
}

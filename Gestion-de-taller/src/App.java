import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Gestion de taller");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar vehiculo");
        System.out.println("3. Crear servicio");

        System.out.println("Hola");

        Connection conexion = ConexionBD.conectar();
        if (conexion != null) {
        System.out.println("Conexión establecida correctamente.");
        } else {
        System.out.println("No se pudo establecer la conexión.");
        }
    
    }
}



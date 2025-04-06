package view;
import dao.ConsultasDao;
import java.util.Scanner;

public class ConsultasView {

    Scanner scanner = new Scanner(System.in);
    ConsultasDao consultasDao = new ConsultasDao();

    public void Consultas(){

        int opcion = 0;

        do { 
            System.out.println("                          ");
            System.out.println("==========================");
            System.out.println("                          ");
            System.out.println("Que consultas desea realizar");
            System.out.println("1. Muestra todos los vehiculos junto con el nombre del cliente propietario");
            System.out.println("2. Que clientes tienen coches con menos de 30000km");
            System.out.println("3. Que clientes tienen coches anteriores a 2020");
            System.out.println("4. Lista todos los productos del inventario junto con el nombre del proveedor");
            System.out.println("5. Que productos tienen un precio mayor a 50 euros por unidad");
            System.out.println("6. Que empleados cobran mas de 2500 euros al mes");
            System.out.println("7. Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1-> consultasDao.mostrarVehiculosConClientes();
                case 2 -> consultasDao.mostrarClientesConMenosDe30000Km();
                case 3 -> consultasDao.cocheAnteriores2020();
                case 4 -> consultasDao.mostrarProductosConProveedores();
                case 5 -> consultasDao.mostrarProductosConPrecioMayorA50();
                case 6 -> consultasDao.mostrarEmpleadosConSalarioMayorA2500();
                case 7 -> System.out.println("Saliendo de las consultas...");
                default -> System.out.println("Opcion no valida, por favor intente de nuevo.");
            }
        } while (opcion!=7);
    }
}

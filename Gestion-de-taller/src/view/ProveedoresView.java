package view;
import dao.ProveedoresDao;
import java.util.ArrayList;
import java.util.Scanner;
import model.Proveedores;

public class ProveedoresView {

    private ArrayList<Proveedores> proveedores = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private ProveedoresDao proveedoresDao = new ProveedoresDao();

    public void gestionProveedores(){
        System.out.println("Gestion de Proveedores");
        System.out.println("1. Agregar proveedor");
        System.out.println("2. Eliminar proveedor"); 
        System.out.println("3. Actualizar datos proveedor");
        System.out.println("4. Mostrar todos los proveedores");
        System.out.println("5. Salir");
        int opcion = 0;

        switch(opcion){
            case 1-> {
                System.out.println("Ingrese el nombre del proveedor: ");
                String nombreProveedor = scanner.nextLine();
                System.out.println("Ingrese el telefono del proveedor: ");
                String telefono = scanner.nextLine();
                System.out.println("Ingrese la direccion del proveedor: ");
                String direccion = scanner.nextLine();
                System.out.println("Ingrese el email del proveedor: ");
                String email = scanner.nextLine();
                Proveedores proveedor = new Proveedores(nombreProveedor, telefono, direccion, email);  
                proveedores.add(proveedor);
                proveedoresDao.insertar(proveedor);
            }
        }

    }
}

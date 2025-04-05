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
        int opcion = 0;
        do {
            System.out.println("Que desea realizar");
            System.out.println("1. Agregar proveedor");
            System.out.println("2. Eliminar proveedor"); 
            System.out.println("3. Actualizar datos proveedor");
            System.out.println("4. Mostrar todos los proveedores");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
        
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

                case 2-> {
                    System.out.println("Ingrese el nombre del proveedor a eliminar: ");
                    String nombre = scanner.nextLine();
                    proveedoresDao.eliminarProveedor(nombre);
                }

                case 3 -> { 
                    int opcionActualizar = 0;
                    do {
                        System.out.println("Ingrese el nombre del proveedor a actualizar: ");
                        String nombre = scanner.nextLine();
                        if (proveedoresDao.obtenerPorNombre(nombre) == null) {
                            System.out.println("Proveedor no encontrado.");
                            break;
                        }
                        System.out.println("Que desea actualizar?");
                        System.out.println("1. Nombre del proveedor");
                        System.out.println("2. Telefono del proveedor");
                        System.out.println("3. Direccion del proveedor");
                        System.out.println("4. Email del proveedor");
                        System.out.println("5. Salir");
                        opcionActualizar = scanner.nextInt();
                        scanner.nextLine(); 

                        switch(opcionActualizar) {
                            case 1 -> {
                                System.out.println("Ingrese el nuevo nombre del proveedor: ");
                                String nuevoNombre = scanner.nextLine();
                                proveedoresDao.actualizarNombre(nombre, nuevoNombre);
                            }
                            case 2 -> {
                                System.out.println("Ingrese el nuevo telefono del proveedor: ");
                                String nuevoTelefono = scanner.nextLine();
                                proveedoresDao.actualizarTelefono(nombre, nuevoTelefono);
                            }
                            case 3 -> {
                                System.out.println("Ingrese la nueva direccion del proveedor: ");
                                String nuevaDireccion = scanner.nextLine();
                                proveedoresDao.actualizarDireccion(nombre, nuevaDireccion);
                            }
                            case 4 -> {
                                System.out.println("Ingrese el nuevo email del proveedor: ");
                                String nuevoEmail = scanner.nextLine();
                                proveedoresDao.actualizarEmail(nombre, nuevoEmail);
                            }
                            case 5 -> {
                                System.out.println("Saliendo de la actualización");
                            }
                            default -> System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    } while (opcionActualizar != 5);
                }
                case 4 -> {
                    System.out.println("Lista de Proveedores:");
                    ArrayList<Proveedores> listaProveedores = proveedoresDao.obtenerTodos();
                    for (Proveedores proveedor : listaProveedores) {
                        System.out.println(proveedor.toString());
                    }
                }
                case 5 -> {
                    System.out.println("Saliendo de la gestión de proveedores...");
                }
                default ->{
                    System.out.println("Opción no válida, intente nuevamente.");
                } 
            }
        } while(opcion != 5);
    }
}

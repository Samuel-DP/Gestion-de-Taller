package view;

import dao.InventarioDao;
import java.util.ArrayList;
import java.util.Scanner;
import model.Inventario;

public class InventarioView {
    private ArrayList<Inventario> inventarios = new ArrayList<>();
    private InventarioDao inventarioDao = new InventarioDao();
    private Scanner scanner = new Scanner(System.in);
    
    public void gestionInventario(){
        int opcion = 0;
        
        do { 
            System.out.println("                          ");
            System.out.println("==========================");
            System.out.println("                          ");
            System.out.println("Que desea realizar");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto"); 
            System.out.println("3. Actualizar datos producto");
            System.out.println("4. Mostrar todos los productos");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

        switch(opcion) {
            case 1 -> {
                System.out.println("                          ");
                System.out.println("==========================");
                System.out.println("                          ");
                System.out.println("Ingrese el nombre del producto: ");
                String nombreProducto = scanner.nextLine();
                System.out.println("Ingrese la cantidad del producto: ");
                int cantidad = scanner.nextInt();
                System.out.println("Ingrese el precio unitario del producto: ");
                double precioUnitario = scanner.nextDouble();
                System.out.println("Ingrese el id del proveedor: ");
                int idProveedor = scanner.nextInt();
                scanner.nextLine();
                Inventario inventario = new Inventario(nombreProducto, cantidad, precioUnitario, idProveedor);  
                inventarios.add(inventario);
                inventarioDao.insertar(inventario);
            }
            case 2 -> {
                System.out.println("Ingrese el nombre del producto a eliminar: ");
                String nombre = scanner.nextLine();
                inventarioDao.eliminar(nombre);
            }

            case 3 -> { 
                int opcionActualizar = 0;

                do {
                    System.out.println("Ingrese el nombre del producto a actualizar: ");
                    String nombre = scanner.nextLine();

                    if (inventarioDao.obtenerPorNombre(nombre) == false) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }
                    System.out.println("                          ");
                    System.out.println("==========================");
                    System.out.println("                          ");
                    System.out.println("Que desea actualizar");
                    System.out.println("1. Nombre del producto");
                    System.out.println("2. Cantidad del producto");
                    System.out.println("3. Precio unitario del producto");
                    System.out.println("4. Salir");
                    opcionActualizar = scanner.nextInt();

                    scanner.nextLine(); 

                    switch(opcionActualizar) {
                        case 1 -> {
                            System.out.println("Ingrese el nuevo nombre del producto: ");
                            String nuevoNombre = scanner.nextLine();
                            inventarioDao.actualizarNombre(nombre, nuevoNombre);
                            return;
                        }
                        case 2 -> {
                            System.out.println("Ingrese la nueva cantidad del producto: ");
                            int nuevaCantidad = scanner.nextInt();
                            inventarioDao.actualizarCantidad(nombre, nuevaCantidad);
                            return;
                        } 
                        case 3 -> {
                            System.out.println("Ingrese el nuevo precio unitario del producto: ");
                            double nuevoPrecio = scanner.nextDouble();
                            inventarioDao.actualizarPrecioUnitario(nombre, nuevoPrecio);
                            return;
                        }
                        case 4 -> {
                            System.out.println("Saliendo de la actualización");
                        }
                        default -> {
                            System.out.println("Opción no válida, intente nuevamente.");
                        }
                    }
                } while (opcionActualizar != 4);
                
            }
            case 4 -> {
                System.out.println("Lista de productos: ");
                ArrayList<Inventario> listaProductos = inventarioDao.obtenerTodos();
                for (Inventario producto : listaProductos) {
                    System.out.println(producto.toString());
                }
            }
            case 5 -> {
                System.out.println("Saliendo del programa");
            }
            default -> {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }

        } while (opcion != 5);
        

    }
    
    
}

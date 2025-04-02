package view;

import dao.InventarioDao;
import java.util.ArrayList;
import java.util.Scanner;
import model.Inventario;

public class InvetarioView {
    private ArrayList<Inventario> inventarios = new ArrayList<>();
    private InventarioDao inventarioDao = new InventarioDao();
    private Scanner scanner = new Scanner(System.in);
    
    public void gestionInventario(){
        int opcion = 0;
        
        do { 
            System.out.println("Que desea realizar?");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto"); 
            System.out.println("3. Actualizar datos producto");
            System.out.println("4. Mostrar todos los productos");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

        switch(opcion) {
            case 1 -> {
                System.out.println("Ingrese el nombre del producto: ");
                String nombreProducto = scanner.nextLine();
                System.out.println("Ingrese la cantidad del producto: ");
                int cantidad = scanner.nextInt();
                System.out.println("Ingrese el precio unitario del producto: ");
                double precioUnitario = scanner.nextDouble();
                Inventario inventario = new Inventario(nombreProducto, cantidad, precioUnitario);  
                inventarios.add(inventario);
                inventarioDao.insertar(inventario);
            }
            case 2 -> {
                System.out.println("Ingrese el nombre del producto a eliminar: ");
                String nombre = scanner.nextLine();
                inventarioDao.eliminar(nombre);
            }

            case 3 -> { //HAcer bien NO FUNCIAAA
                int opcionActualizar = 0;
                do {
                System.out.println("Ingrese el nombre del producto a actualizar: ");
                String nombre = scanner.nextLine();
                if (inventarioDao.obtenerPorNombre(nombre) == null) {
                    System.out.println("Producto no encontrado.");
                    
                }
                System.out.println("Que desea actualizar?");
                System.out.println("1. Nombre del producto");
                System.out.println("2. Cantidad del producto");
                System.out.println("3. Precio unitario del producto");
                System.out.println("4. Salir");
                opcionActualizar = scanner.nextInt();
                } while (opcionActualizar != 4);
            }
            case 4 -> {
                System.out.println("Lista de productos: ");
                for (Inventario inventario : inventarios) {
                    System.out.println(inventario.toString());
                }
            }

        }

        } while (opcion != 5);
        

    }
    
    
}

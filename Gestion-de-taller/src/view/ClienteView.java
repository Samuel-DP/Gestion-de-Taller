package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {
    private final List<Cliente> clientes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final ClientesDao ClientesDao = new ClientesDao();

    public Cliente crearCliente() {
        String nombreCliente;
        String apellidoCliente;
        String dniCliente;
        int telefonoCliente;

        System.out.println("Ingresa un nombre: ");
        nombreCliente = scanner.nextLine();
        System.out.println("Ingresa un apellido: ");
        apellidoCliente = scanner.nextLine();
        System.out.println("Ingrese el DNI: ");
        dniCliente = scanner.nextLine();
        System.out.println("Ingrese el teléfono: ");
        telefonoCliente = scanner.nextInt();

        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, dniCliente, telefonoCliente);
        clientes.add(cliente);
        return cliente;
        
    }

    public gestionarCliente() {
        int opcion;
        do { 
            System.out.println("1. Insertar cliente en la base de datos");
            System.out.println("2. Eliminar cliente de la base de datos");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Mostrar todos los clientes");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

        } while (opcion != 5);
    }

    switch(opcion) {
        case 1 -> {
            ClientesDao.insertar(cliente);
        }
        case 2 -> {
            System.out.println("Ingrese el ID del cliente a eliminar: ");
            int id_cliente = scanner.nextInt();
            ClientesDao.eliminar(id_cliente);
        }
        case 3 -> {
            System.out.println("Ingrese el ID del cliente a buscar: ");
            int id_cliente = scanner.nextInt();
            Cliente clienteBuscado = ClientesDao.buscarPorId(id_cliente);
            if (clienteBuscado != null) {
                System.out.println(clienteBuscado.toString());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        }
        case 4 -> {
            System.out.println("Mostrando todos los clientes...");
            List<Cliente> listaClientes = ClientesDao.obtenerTodos();
            for (Cliente c : listaClientes) {
                System.out.println(c.toString());
            }
        }
        default -> System.out.println("Opción no válida, intente nuevamente.");
    }

}
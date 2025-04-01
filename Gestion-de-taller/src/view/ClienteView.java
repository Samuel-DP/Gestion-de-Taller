package view;

import dao.ClientesDao;
import java.util.ArrayList;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private ClientesDao ClientesDao = new ClientesDao();

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
        ClientesDao.insertar(cliente);
        return cliente;
        
    }

    public void gestionarCliente() {
        String dni = "";
        int opcion;
        do { 
            System.out.println("1. Eliminar cliente");
            System.out.println("2. Actualizar datos cliente");
            System.out.println("3. Mostrar todos los clientes");
            System.out.println("4. Mostrar datos de un cliente");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcion) {
                case 1 -> {
                    System.out.println("Ingrese el DNI del cliente a eliminar: ");
                    dni = scanner.nextLine();
                    ClientesDao.eliminar(dni);
                }
                case 2 -> {
                    System.out.print("Ingrese el DNI del cliente a actualizar: "); 
                    dni = scanner.nextLine();
                    int respuesta;
                    do { 
                        System.out.println("1. Actualizar nombre");
                        System.out.println("2. Actualizar apellido");
                        System.out.println("3. Actualizar DNI");
                        System.out.println("4. Actualizar telefono");
                        System.out.println("5. Salir");
                        respuesta = scanner. nextInt();
                        scanner.nextLine();

                        switch(respuesta){
                            case 1 -> {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nombre = scanner.nextLine();
                                ClientesDao.ActualizarNombre(dni, nombre);
                            }
                            case 2 -> {
                                System.out.println("Ingrese el nuevo apellido: ");
                                String apellido = scanner.nextLine();
                                ClientesDao.ActualizarApellido(dni, apellido);
                            }
                            case 3 -> {
                                System.out.println("Ingrese el nuevo DNI: ");
                                String nuevoDni = scanner.nextLine();
                                ClientesDao.ActualizarDni(dni, nuevoDni);
                            }
                            case 4 -> {
                                System.out.println("Ingrese el nuevo telefono: ");
                                int tlf = scanner.nextInt();
                                scanner.nextLine();
                                ClientesDao.ActualizarTelefono(dni, tlf);    
                            }
                        }
                    } while (respuesta!= 5);
                }
                case 3 -> {
                    System.out.println("Mostrando todos los clientes...");
                    ArrayList<Cliente> listaClientes = ClientesDao.obtenerTodos();
                    for (Cliente c : listaClientes) {
                        System.out.println(c.toString());
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el DNI del cliente: ");
                    dni = scanner.nextLine();
                    Cliente cliente = ClientesDao.obtenerPorDni(dni);
                    if (cliente != null) {
                        System.out.println(cliente.toString());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                }
                case 5 -> System.out.println("Saliendo de gestión de clientes...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }

        } while (opcion != 5);
    }
}
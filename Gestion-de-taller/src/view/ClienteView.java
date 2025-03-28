package view;
import model.Cliente;
private List<Cliente> clientes = new ArrayList<>();
Scanner scanner = new Scanner(System.in);

public Cliente crearCliente(){
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
    return cliente;
}
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;

public class ClienteView {
    private final List<Cliente> clientes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

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

}
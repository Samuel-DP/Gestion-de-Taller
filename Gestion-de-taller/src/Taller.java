
import java.util.Scanner;


public class Taller {
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

    public Vehiculo crearVehiculo(){
        String matriculaVehiculo;
        String marcaVehiculo;
        String modeloVehiculo;
        int añoVehiculo;
        int kmVehiculo;
        String nBastidorVehiculo;

        System.out.println("Ingrese una matricula: ");
        matriculaVehiculo = scanner.nextLine();
        System.out.println("Ingrese una marca: ");
        marcaVehiculo = scanner.nextLine();
        System.out.println("Ingrese un modelo: ");
        modeloVehiculo = scanner.nextLine();
        System.out.println("Ingrese un año: ");
        añoVehiculo = scanner.nextInt();        
        System.out.println("Ingrese kms del vehiculo: ");
        kmVehiculo = scanner.nextInt();
        System.out.println("Ingrese el numero de bastidor: ");
        nBastidorVehiculo = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(matriculaVehiculo, marcaVehiculo, modeloVehiculo, añoVehiculo, kmVehiculo, nBastidorVehiculo);
        return vehiculo;
    }

    public Servicio crearServicio(){
        String descripcionServicio;
        Double precioServicio;
        Double horasServicio;
       
        System.out.println("Ingrese una descripcion del servicio: ");
        descripcionServicio = scanner.nextLine();
        System.out.println("Ingrese un precio por h del servicio: ");
        precioServicio = scanner.nextDouble();
        System.out.println("Ingrese las horas estimadas del servicio: ");
        horasServicio = scanner.nextDouble();

        Servicio servicio = new Servicio(descripcionServicio, precioServicio, horasServicio);
        return servicio;
    }
}

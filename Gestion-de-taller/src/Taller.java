
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.Empleado;
import model.Servicio;
import model.Vehiculo;


public class Taller {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Servicio> servicios = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
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

    public Empleado crearEmpleado(){
        String nombreEmpleado;
        String apellidoEmpleado;
        String dniEmpleado;
        String puestoEmpleado;
        int salarioEmpleado;

        System.out.println("Ingresa un nombre: ");
        nombreEmpleado = scanner.nextLine();
        System.out.println("Ingresa un apellido: ");
        apellidoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el DNI: ");
        dniEmpleado = scanner.nextLine();
        System.out.println("Ingrese el puesto: ");
        puestoEmpleado = scanner.nextLine();
        System.out.println("Ingrese el salario: ");
        salarioEmpleado = scanner.nextInt();

        Empleado empleado = new Empleado(nombreEmpleado, apellidoEmpleado, dniEmpleado, puestoEmpleado, salarioEmpleado);
        return empleado;
    }

   
    public void asignarServicio() {
        System.out.println("=== Asignar Servicio ===");
        
        System.out.println("¿Desea crear un nuevo servicio (1) o seleccionar uno existente (2)?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        Servicio servicio;
        if (opcion == 1) {
            servicio = crearServicio();
        } else {
            System.out.println("Ingrese la descripción del servicio a asignar:");
            String descripcion = scanner.nextLine();
            System.out.println("Ingrese el precio del servicio: ");
            Double precio = scanner.nextDouble();
            System.out.println("Ingrese las horas del servicio: ");
            Double horas = scanner.nextDouble();
            servicio = new Servicio(descripcion, precio, horas); 
        }
        
        System.out.println("=== Seleccionar Empleado ===");
        System.out.println("¿Desea crear un nuevo empleado (1) o seleccionar uno existente (2)?");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        Empleado empleado;
        if (opcion == 1) {
            empleado = crearEmpleado();
        } else {
            System.out.println("Ingrese el nombre del empleado:");
            String nombreEmpleado = scanner.nextLine();
            System.out.println("Ingrese el apellido del empleado:");
            String apellidoEmpleado = scanner.nextLine();
            System.out.println("Ingrese el DNI del empleado:");
            String dniEmpleado = scanner.nextLine();
            System.out.println("Ingrese el puesto del empleado:");
            String puestoEmpleado = scanner.nextLine();
            System.out.println("Ingrese el salario del empleado:");
            int salarioEmpleado = scanner.nextInt();
            empleado = new Empleado(nombreEmpleado,apellidoEmpleado, dniEmpleado,puestoEmpleado, salarioEmpleado); // Ejemplo, deberías buscar el empleado real
        }
        
        
        System.out.println("=== Seleccionar Vehículo ===");
        System.out.println("¿Desea crear un nuevo vehículo (1) o seleccionar uno existente (2)?");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        Vehiculo vehiculo;
        if (opcion == 1) {
            vehiculo = crearVehiculo();
        } else {
            System.out.println("Ingrese la matricula del vehículo:");
            String matricula = scanner.nextLine();
            System.out.println("Ingrese el marca del vehículo:");
            String marca = scanner.nextLine();
            System.out.println("Ingrese el modelo del vehículo:");
            String modelo = scanner.nextLine();
            System.out.println("Ingrese el año del vehículo:");
            int año = scanner.nextInt();
            System.out.println("Ingrese los km del vehículo:");
            int km = scanner.nextInt();
            System.out.println("Ingrese el número de bastidor del vehículo:");
            String nBastidor = scanner.nextLine();
            vehiculo = new Vehiculo(matricula, marca, modelo, año, km, nBastidor); // Ejemplo, deberías buscar el vehículo real
        }
        
        
        servicio.asignarEmpleado(empleado);
        servicio.asignarVehiculo(vehiculo);
        empleado.agregarServicio(servicio);
        vehiculo.agregarServicio(servicio);
        
        System.out.println("Servicio asignado correctamente:");
        System.out.println("Servicio: " + servicio.getDescripcion());
        System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " (" + vehiculo.getMatricula() + ")");
    }
   
}


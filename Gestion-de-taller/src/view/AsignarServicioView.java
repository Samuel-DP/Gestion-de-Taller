package view;

import java.util.Scanner;
import model.Empleado;
import model.Servicio;
import model.Vehiculo;

public class AsignarServicioView {
    Scanner scanner = new Scanner(System.in);
    ServicioView servicioView = new ServicioView();
    Servicio servicio = servicioView.crearServicio();

    EmpleadoView empleadoView = new EmpleadoView();
    Empleado empleado = empleadoView.crearEmpleado();

    VehiculoView vehiculoView = new VehiculoView();
    Vehiculo vehiculo = vehiculoView.crearVehiculo();

     public void asignarServicio() {
        System.out.println("=== Asignar Servicio ===");
        
        System.out.println("¿Desea crear un nuevo servicio (1) o seleccionar uno existente (2)?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        if (opcion == 1) {
            servicio = servicioView.crearServicio();
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
        
    
        if (opcion == 1) {
            empleado = empleadoView.crearEmpleado();
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
            empleado = new Empleado(nombreEmpleado,apellidoEmpleado, dniEmpleado,puestoEmpleado, salarioEmpleado); 
        }
        
        
        System.out.println("=== Seleccionar Vehículo ===");
        System.out.println("¿Desea crear un nuevo vehículo (1) o seleccionar uno existente (2)?");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        
        if (opcion == 1) {
            vehiculo = vehiculoView.crearVehiculo();
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
            vehiculo = new Vehiculo(matricula, marca, modelo, año, km, nBastidor); 
        }
        
        
        servicio.asignarEmpleado(this.empleado);
        servicio.asignarVehiculo(this.vehiculo);
       
        
        System.out.println("Servicio asignado correctamente:");
        System.out.println("Servicio: " + servicio.getDescripcion());
        System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " (" + vehiculo.getMatricula() + ")");
    }
    
}

package view;

import dao.EmpleadoDao;
import dao.ServicioDao;
import dao.VehiculosDao;
import java.util.Scanner;
import model.Empleado;
import model.Servicio;
import model.Vehiculo;

public class AsignarServicioView {
    private Scanner scanner = new Scanner(System.in);
    private ServicioView servicioView = new ServicioView();
    private EmpleadoView empleadoView = new EmpleadoView();
    private VehiculoView vehiculoView = new VehiculoView();
    private ServicioDao servicioDao = new ServicioDao();
    private EmpleadoDao empleadoDao = new EmpleadoDao();
    private VehiculosDao vehiculosDao = new VehiculosDao();

    public void asignarServicio() {
        System.out.println("=== Asignar Servicio ===");
        Servicio servicio = obtenerServicio();
        Empleado empleado = obtenerEmpleado();
        Vehiculo vehiculo = obtenerVehiculo();

        System.out.println("Servicio asignado correctamente:");
        System.out.println("Servicio: " + servicio.getDescripcion());
        System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " (" + vehiculo.getMatricula() + ")");
    }

    private Servicio obtenerServicio() {
        System.out.println("¿Desea crear un nuevo servicio (1) o seleccionar uno existente (2)?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            Servicio servicio = servicioView.crearServicio();
            servicioDao.insertar(servicio);
            return servicio;
        } else {
            System.out.println("Ingrese la descripción del servicio a asignar:");
            String descripcion = scanner.nextLine();
            Servicio servicio = servicioDao.obtenerPorDescripcion(descripcion);
            if (servicio == null){
                System.out.println("Servicio no encontrado, por favor cree uno nuevo");
                return obtenerServicio();
            }
            return servicio;
        }
    }

    private Empleado obtenerEmpleado() {
        System.out.println("¿Desea crear un nuevo empleado (1) o seleccionar uno existente (2)?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            Empleado empleado = empleadoView.crearEmpleado();
            empleadoDao.insertar(empleado);
            return empleado;
        } else {
            System.out.println("Ingrese el dni del empleado:");
            String dni = scanner.nextLine();
            Empleado empleado = empleadoDao.obtenerPorDni(dni);
            if (empleado == null){
                System.out.println("Empleado no encontrado, por favor cree uno nuevo");
                return obtenerEmpleado();
            }
            return empleado;
        }
    }

    private Vehiculo obtenerVehiculo() {
        System.out.println("¿Desea crear un nuevo vehículo (1) o seleccionar uno existente (2)?");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            Vehiculo vehiculo = vehiculoView.crearVehiculo();
            vehiculosDao.insertar(vehiculo);
            return vehiculo;
        } else {
            System.out.println("Ingrese la matricula del vehículo:");
            String matricula = scanner.nextLine();
            Vehiculo vehiculo = vehiculosDao.buscarVehiculo(matricula);
            if (vehiculo == null){
                System.out.println("Vehículo no encontrado, por favor cree uno nuevo");
                return obtenerVehiculo();
            }
            return vehiculo;
        }
    }
}
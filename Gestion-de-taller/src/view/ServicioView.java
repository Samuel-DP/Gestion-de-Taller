package view;

import dao.ServicioDao;
import java.util.Scanner;
import model.Servicio;

public class ServicioView {
    private Scanner scanner = new Scanner(System.in);
    private ServicioDao servicioDao = new ServicioDao();

    public Servicio crearServicio() {
        System.out.println("Ingrese la descripción del servicio:");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio del servicio:");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese las horas del servicio:");
        double horas = scanner.nextDouble();
        scanner.nextLine();

        Servicio servicio = new Servicio(descripcion, precio, horas);
        servicioDao.insertar(servicio);
        return servicio;
    }

    public void actualizarServicio() {
        System.out.println("Ingrese la descripción del servicio a actualizar:");
        String descripcion = scanner.nextLine();
        Servicio servicio = servicioDao.obtenerPorDescripcion(descripcion);

        if (servicio != null) {
            System.out.println("¿Qué desea actualizar?");
            System.out.println("1. Descripción");
            System.out.println("2. Precio");
            System.out.println("3. Horas");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la nueva descripción:");
                    String nuevaDescripcion = scanner.nextLine();
                    servicioDao.actualizarDescripcion(descripcion, nuevaDescripcion);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo precio:");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine();
                    servicioDao.actualizarPrecio(descripcion, nuevoPrecio);
                    break;
                case 3:
                    System.out.println("Ingrese las nuevas horas:");
                    double nuevasHoras = scanner.nextDouble();
                    scanner.nextLine();
                    servicioDao.actualizarHoras(descripcion, nuevasHoras);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } else {
            System.out.println("Servicio no encontrado.");
        }
    }

    public void eliminarServicio() {
        System.out.println("Ingrese la descripción del servicio a eliminar:");
        String descripcion = scanner.nextLine();
        servicioDao.eliminar(descripcion);
    }

    public void mostrarServicios() {
        System.out.println("Lista de servicios:");
        for (Servicio servicio : servicioDao.obtenerTodos()) {
            System.out.println("Descripción: " + servicio.getDescripcion() +
                    ", Precio: " + servicio.getPrecio() +
                    ", Horas: " + servicio.getHoras());
        }
    }

    public Servicio obtenerServicioPorDescripcion() {
        System.out.println("Ingrese la descripción del servicio a buscar:");
        String descripcion = scanner.nextLine();
        return servicioDao.obtenerPorDescripcion(descripcion);
    }
}
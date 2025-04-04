package view;

import dao.CitasDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Citas;
import model.Vehiculo;


public class CitasView {
    private static List<Citas> listaCitas = new ArrayList<>();
    private Vehiculo vehiculo;
    private CitasDao citasDao = new CitasDao();
    public void crearCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha (00-00-0000): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora (HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el DNI del cliente: ");
        String clienteDni = scanner.nextLine();
        
        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();
    
        
        if (vehiculo.getMatricula() == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }
            
        System.out.print("Ingrese la descripción de la cita: ");
        String descripcion = scanner.nextLine();

        System.out.println("Estado de la cita:");
        String estado = scanner.nextLine();
        if (estado.equalsIgnoreCase("pendiente")) {
            System.out.println("Cita pendiente.");
        } else if (estado.equalsIgnoreCase("confirmada")) {
            System.out.println("Cita confirmada.");
        } else if (estado.equalsIgnoreCase("cancelada")) {
            System.out.println("Cita cancelada.");
        } else {
            System.out.println("Estado no válido. La cita se guardará como pendiente.");
        }

        Citas cita = new Citas(fecha, hora, clienteDni, matricula, descripcion, estado);
        listaCitas.add(cita);
        citasDao.insertar(cita);
        System.out.println("Cita creada con éxito.");
    

}

    private void buscarCitaPorDni(String dniCliente) {
        boolean buscar = false;
        for (Citas cita : listaCitas) {
            if (cita.getClienteDni().equals(dniCliente)) {
                System.out.println("=== Cita Encontrada ===");
                System.out.println("Fecha: " + cita.getFecha());
                System.out.println("Hora: " + cita.getHora());
                System.out.println("DNI del Cliente: " + cita.getClienteDni());
                System.out.println("Matrícula del Vehículo: " + cita.getVehiculoMatricula());
                System.out.println("Descripción: " + cita.getDescripcion());
                System.out.println("------------------------");
                buscar = true;
            }
        }
        if (!buscar) {
            System.out.println("No se encontró ninguna cita con el DNI proporcionado.");
        }
    }

    private void buscarCitaPorMatricula(String matriculaVehiculo) {
        boolean buscar = false;
        for (Citas cita : listaCitas) {
            if (cita.getVehiculoMatricula().equals(matriculaVehiculo)) {
                System.out.println("=== Cita Encontrada ===");
                System.out.println("Fecha: " + cita.getFecha());
                System.out.println("Hora: " + cita.getHora());
                System.out.println("DNI del Cliente: " + cita.getClienteDni());
                System.out.println("Matrícula del Vehículo: " + cita.getVehiculoMatricula());
                System.out.println("Descripción: " + cita.getDescripcion());
                System.out.println("------------------------");
                buscar = true;
            }
        }
        if (!buscar) {
            System.out.println("No se encontró ninguna cita con la matrícula proporcionada.");
        }
    }

    public void mostrarCitas() {
        System.out.println("=== Lista de Citas ===");
        for (Citas cita : listaCitas) {
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());
            System.out.println("DNI del Cliente: " + cita.getClienteDni());
            System.out.println("Matrícula del Vehículo: " + cita.getVehiculoMatricula());
            System.out.println("Descripción: " + cita.getDescripcion());
            System.out.println("------------------------");
            citasDao.obtenerTodas();
        }
    }

    public void gestionarCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gestión de Citas ===");
        System.out.println("1. Mostrar citas");
        System.out.println("2. Buscar cita por DNI del cliente");
        System.out.println("3. Buscar cita por matrícula del vehículo");
        System.out.println("4. Cambiar estado de cita");
        System.out.println("5. Eliminar cita");
        System.out.println("6. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1 -> mostrarCitas();
            case 2 -> {
                System.out.print("Ingrese el DNI del cliente: ");
                String dniCliente = scanner.nextLine();
                buscarCitaPorDni(dniCliente);
                citasDao.obtenerPorDni(dniCliente);
                }
            case 3 -> {
                System.out.print("Ingrese la matrícula del vehículo: ");
                String matriculaVehiculo = scanner.nextLine();
                buscarCitaPorMatricula(matriculaVehiculo);
                citasDao.obtenerPorMatricula(matriculaVehiculo);
            }
            case 4 -> {
                System.out.print("Ingrese el DNI del cliente: ");
                String dniCliente = scanner.nextLine();
                System.out.print("Ingrese el nuevo estado de la cita: ");
                String nuevoEstado = scanner.nextLine();
                citasDao.actualizarEstado(dniCliente, nuevoEstado);
            }
            case 5 ->{
                System.out.print("Ingrese el DNI del cliente: ");
                String dniClienteEliminar = scanner.nextLine();
                boolean encontrado = false;
                for (Citas cita : listaCitas) {
                    if (cita.getClienteDni().equals(dniClienteEliminar)) {
                        listaCitas.remove(cita);
                        System.out.println("Cita eliminada con éxito.");
                        citasDao.eliminar(dniClienteEliminar);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ninguna cita con el DNI proporcionado.");
                }
            }
            case 6 -> {
                System.out.println("Saliendo de la gestión de citas.");
            }            
            default ->
                System.out.println("Opción no válida.");
        }
    }
}

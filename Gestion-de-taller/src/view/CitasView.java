package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Citas;
import model.Vehiculo;
public class CitasView {
    private static List<Citas> listaCitas = new ArrayList<>();
    

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
     
        Vehiculo vehiculo = new Vehiculo(matricula, "", "", 0, 0, "");   
                
        if (vehiculo.getMatricula() == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        System.out.print("Ingrese la descripción de la cita: ");
        String descripcion = scanner.nextLine();

        Citas cita = new Citas(fecha, hora, clienteDni, vehiculo, descripcion);
        listaCitas.add(cita);
        System.out.println("Cita creada con éxito.");
    }

    public void mostrarCitas() {
        System.out.println("=== Lista de Citas ===");
        for (Citas cita : listaCitas) {
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());
            System.out.println("DNI del Cliente: " + cita.getClienteDni());
            System.out.println("Matrícula del Vehículo: " + vehiculo.getMatricula());
            System.out.println("Descripción: " + cita.getDescripcion());
            System.out.println("------------------------");
        }
    }
}

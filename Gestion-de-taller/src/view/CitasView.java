/*package view;

import java.util.Scanner;
import model.Vehiculo;
import model.Citas;
public class CitasView {
    Vehiculo vehiculo;
    Citas cita;
    
    public static void crearCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fecha (00-00-0000): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese la hora (HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Ingrese el DNI del cliente: ");
        String clienteDni = scanner.nextLine();

        System.out.print("Ingrese la matrícula del vehículo: ");
        String matricula = scanner.nextLine();
    
        Vehiculo vehiculo = buscarVehiculo(matricula);
        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        System.out.print("Ingrese la descripción de la cita: ");
        String descripcion = scanner.nextLine();

        Citas cita = new Citas(fecha, hora, clienteDni, matricula, descripcion);
        agregarCita(cita);
        System.out.println("Cita creada con éxito.");
    }
}*/

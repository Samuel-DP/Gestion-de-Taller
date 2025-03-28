package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Empleado;

public class EmpleadoView {
    Scanner scanner = new Scanner(System.in);
private List<Empleado> empleados = new ArrayList<>();
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
}

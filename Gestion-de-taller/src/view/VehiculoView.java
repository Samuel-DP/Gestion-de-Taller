package view;

import java.util.Scanner;
import model.Vehiculo;

public class VehiculoView {
    Scanner scanner = new Scanner(System.in);
    
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
    
}
 
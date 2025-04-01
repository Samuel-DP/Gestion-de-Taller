package view;

import dao.VehiculosDao;
import java.util.ArrayList;
import java.util.Scanner;
import model.Vehiculo;
public class VehiculoView {
    Scanner scanner = new Scanner(System.in);
    private VehiculosDao vehiculosDao = new VehiculosDao();
    
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
        vehiculosDao.insertar(vehiculo);
        return vehiculo;
    }

    public void gestionarVehiculo(){
      int respuesta = 0;
      do { 

        System.out.println("1. Eliminar vehiculo");
        System.out.println("2. Actualizar datos vehiculo");
        System.out.println("3. Mostrar todos los vehiculos ");
        System.out.println("4. Mostrar datos de un vehiculo ");
        System.out.println("5. Salir  ");
        respuesta = scanner.nextInt();

        switch(respuesta){
          
          case 1 ->{
            System.out.println("Ingrese la matricula del vehiculo a eliminar");
            String matricula = scanner.nextLine();
            vehiculosDao.eliminar(matricula);
          }

          case 2 ->{
            System.out.println("Introduzca la matricula del coche que desee cambiar");
            String matricula = scanner.nextLine();
            int opcion = 0;
            do { 
              System.out.println("Que desea actualizar");
              System.out.println("1. Matricula");
              System.out.println("2. Marca ");
              System.out.println("3. Modelo ");
              System.out.println("4. Año ");
              System.out.println("5. Kilometros ");
              System.out.println("6. Nº bastidor ");
              System.out.println("7. Salir ");
              opcion = scanner.nextInt();

              switch(respuesta){
                case 1 -> {
                  System.out.println("Introduzca la nueva matricula: ");
                  String matriculaNueva = scanner.nextLine();
                  vehiculosDao.ActualizarMatricula(matricula, matriculaNueva);
                }
                case 2 -> {
                  System.out.println("Introduzca la nueva marca: ");
                  String marcaNueva = scanner.nextLine();
                  vehiculosDao.ActualizarMarca(matricula, marcaNueva);
                }
                case 3 -> {
                  System.out.println("Introduzca el nuevo modelo: ");
                  String modeloNuevo = scanner.nextLine();
                  vehiculosDao.ActualizarModelo(matricula, modeloNuevo);
                }
                case 4 -> {
                  System.out.println("Introduzca el nuevo año: ");
                  int añoNuevo = scanner.nextInt();
                  vehiculosDao.ActualizarAño(matricula, añoNuevo);
                }
                case 5 -> {
                  System.out.println("Introduzca los nuevos kilometros: ");
                  int kmNuevo = scanner.nextInt();
                  vehiculosDao.ActualizarKm(matricula, kmNuevo);
                }
                case 6 -> {
                  System.out.println("Introduzca el nuevo nº de bastidor: ");
                  String nBastidorNuevo = scanner.nextLine();
                  vehiculosDao.ActualizarNºBastidor(matricula, nBastidorNuevo);
                }
                case 7 -> {
                  System.out.println("Saliendo del menu de actualizacion de vehiculo");
                }
              }
            } while (respuesta != 7);
          }

          case 3 -> {
            System.out.println("Mostrando todos los vehiculos: ");
            ArrayList<Vehiculo> listaVehiculos = vehiculosDao.obtenerTodos();
            for (Vehiculo v : listaVehiculos) {
              System.out.println(v.toString());
            }
          }
          case 4 -> {
            System.out.println("Introduzca la matricula del vehiculo que desea mostrar: ");
            String matricula = scanner.nextLine();
            vehiculosDao.mostrarVehiculo(matricula);
          }
          case 5 -> {
            System.out.println("Saliendo del menu de gestion de vehiculos");
          }
          default -> {
            System.out.println("Opcion no valida, intente nuevamente.");
          }
        }
      } while(respuesta != 5);
    }

}

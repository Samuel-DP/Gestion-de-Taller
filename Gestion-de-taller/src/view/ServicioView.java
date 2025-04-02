package view;
import java.util.Scanner;
import model.Servicio;

public class ServicioView {
    Scanner scanner = new Scanner(System.in);
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

    public void mostrarServicio(Servicio servicio) {
        System.out.println("Descripción del servicio: " + servicio.getDescripcion());
        System.out.println("Precio : " + servicio.getPrecio());
        System.out.println("Horas estimadas: " + servicio.getHoras());
    }
}

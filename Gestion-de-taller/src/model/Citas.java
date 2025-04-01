package model;
import java.util.ArrayList;
import java.util.List;

public class Citas {
    private String fecha;
    private String hora;
    private String clienteDni;
    private Vehiculo vehiculoMatricula;
    private String descripcion;
    private static List<Citas> listaCitas = new ArrayList<>();

    public Citas(String fecha, String hora, String clienteDni, Vehiculo vehiculoMatricula, String descripcion) {
        this.fecha = fecha;
        this.hora = hora;
        this.clienteDni = clienteDni;
        this.vehiculoMatricula = vehiculoMatricula;
        this.descripcion = descripcion;
    }

       
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getClienteDni() {
        return clienteDni;
    }
    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }
    public Vehiculo getVehiculoMatricula() {
        return vehiculoMatricula;
    }
    public void setVehiculoMatricula(Vehiculo vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }
    
    public void agregarCita(Citas cita) {
        listaCitas.add(cita);
    }

}

package model;
import java.util.ArrayList;
import java.util.List;

public class Citas {
    private String fecha;
    private String hora;
    private String clienteDni;
    private String vehiculoMatricula;
    private String descripcion;
    private String estado; 
    private static List<Citas> listaCitas = new ArrayList<>();

    public Citas(String fecha, String hora, String clienteDni, String vehiculoMatricula, String descripcion, String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.clienteDni = clienteDni;
        this.vehiculoMatricula = vehiculoMatricula;
        this.descripcion = descripcion;
        this.estado = "pendiente"; 
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
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
    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }
    public void setVehiculoMatricula(String vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}

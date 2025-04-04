package model;

public class Servicio {
    
    private String descripcion;
    private Double precio;
    private Double horas;
    
    
    public Servicio(String descripcion, Double precio, Double horas){
        
        this.descripcion = descripcion;
        this.precio = precio;
        this.horas = horas;
        
    }

    public String getDescripcion(){ return this.descripcion; }
    public Double getPrecio(){ return this.precio; }
    public Double getHoras(){ return this.horas; }
    

    
    
}

package model;

public class Servicio {
    
    private String descripcion;
    private Double precio;
    private Double horas;
    
    private Empleado empleado;
    private Vehiculo vehiculo;

    public Servicio(String descripcion, Double precio, Double horas){
        
        this.descripcion = descripcion;
        this.precio = precio;
        this.horas = horas;
        
    }

    public String getDescripcion(){ return this.descripcion; }
    public Double getPrecio(){ return this.precio; }
    public Double getHoras(){ return this.horas; }
    public Empleado getEmpleado(){ return this.empleado; }
    public Vehiculo geVehiculo(){ return this.vehiculo; }

    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void asignarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}

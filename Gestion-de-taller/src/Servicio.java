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
 
    public void asignarEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void asignarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public String getDescripcion(){return descripcion;}
}

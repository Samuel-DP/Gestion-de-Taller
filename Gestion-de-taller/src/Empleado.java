public class Empleado {
    private String nombre; 
    private String apellidos;
    private String dni;
    private int puesto;
    private int salario;

    public Empleado(String nombre, String apellidos, String dni, int puesto, int salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.puesto = puesto;
        this.salario = salario;
    }
    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }
    public String getNombre() {return nombre;}
    public String getApellido() {return apellidos;}
}

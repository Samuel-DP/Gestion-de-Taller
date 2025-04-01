package model;
public class Cliente {
    
    private String nombre;
    private String apellido;
    private String dni;
    private int telefono;

    public Cliente(String nombre, String apellido, String dni, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }
    public String getDni() { return this.dni; }
    public int getTelefono() { return this.telefono; }
}

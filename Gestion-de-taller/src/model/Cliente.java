package model;
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private int telefono;

    public Cliente(String nombre, String apellidos, String dni, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellidos; }
    public String getDni() { return this.dni; }
    public int getTelefono() { return this.telefono; }
}

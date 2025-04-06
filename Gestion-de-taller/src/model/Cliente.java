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

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setDni(String dni) { this.dni = dni; }
    public void setTelefono(int telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}

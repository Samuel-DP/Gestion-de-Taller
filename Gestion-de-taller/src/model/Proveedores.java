package model;

public class Proveedores {
    private String nombre;
    private String telefono;
    private String direccion;   
    private String email;

    public Proveedores(String nombre, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    public String getNombre() {return nombre; }
    public String getTelefono() {return telefono; }
    public String getDireccion() {return direccion; }
    public String getEmail() {return email; }

    public void setNombre(String nombre) {this.nombre = nombre; }
    public void setTelefono(String telefono) {this.telefono = telefono; }   
    public void setDireccion(String direccion) {this.direccion = direccion; }
    public void setEmail(String email) {this.email = email; }

    @Override
    public String toString() {
        return "Proveedores{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

package model;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    
    private String nombre; 
    private String apellido;
    private String dni;
    private String puesto;
    private double salario;
    private List<Servicio> servicios = new ArrayList<>();

    public Empleado(String nombre, String apellido, String dni, String puesto, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.puesto = puesto;
        this.salario = salario;
    }
    
    public String getNombre() {return this.nombre;}
    public String getApellido() {return this.apellido;}
    public String getDni() {return this.dni;}
    public String getPuesto() {return this.puesto;}
    public double getSalario() {return this.salario;}

    @Override
    public String toString(){
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }
}

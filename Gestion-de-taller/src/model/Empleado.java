package model;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    
    private String nombre; 
    private String apellidos;
    private String dni;
    private String puesto;
    private double salario;
    private List<Servicio> servicios = new ArrayList<>();

    public Empleado(String nombre, String apellidos, String dni, String puesto, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.puesto = puesto;
        this.salario = salario;
    }
    
    public String getNombre() {return this.nombre;}
    public String getApellido() {return this.apellidos;}
    public String getDni() {return this.dni;}
    public String getPuesto() {return this.puesto;}
    public double getSalario() {return this.salario;}
}

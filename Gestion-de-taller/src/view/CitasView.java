package view;

public class CitasView {
    private String fecha;
    private String hora;
    private String clienteDni;
    private String vehiculoMatricula;
    private String servicioNombre;

    public CitasView(String fecha, String hora, String clienteDni, String vehiculoMatricula, String servicioNombre) {
        this.fecha = fecha;
        this.hora = hora;
        this.clienteDni = clienteDni;
        this.vehiculoMatricula = vehiculoMatricula;

        this.servicioNombre = servicioNombre;
    }

    public void mostrarCita() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Cliente DNI: " + clienteDni);
        System.out.println("Vehículo Matrícula: " + vehiculoMatricula);
        System.out.println("Servicio Nombre: " + servicioNombre);
    }

   
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getClienteDni() {
        return clienteDni;
    }
    public void setClienteDni(String clienteDni) {
        this.clienteDni = clienteDni;
    }
    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }
    public void setVehiculoMatricula(String vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }
    

}

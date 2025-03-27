

public class Vehiculo{

    private String matricula;
    private String marca;
    private String modelo;
    private int año;
    private int km;
    private String nBastidor;

    public Vehiculo(String matricula,String marca, String modelo, int año, int km, String nBastidor  ){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.km = km;
        this.nBastidor = nBastidor;
    }
    
    public String getnBastidor() { return this.nBastidor; }
    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }
    public String getMarca(){return this.marca;}
    public String getModelo(){return this.modelo;}
    public String getMatricula(){return this.matricula;}
}
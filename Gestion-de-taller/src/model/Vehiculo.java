package model;

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
    public String getMarca(){return this.marca;}
    public String getModelo(){return this.modelo;}
    public String getMatricula(){return this.matricula;}
    public int getAño(){return this.año;}
    public int getKm(){return this.km;}
    public String getNbastidor(){return this.nBastidor;}

    public void setMatricula(String matricula){this.matricula = matricula;}
    public void setMarca(String marca){this.marca = marca;}
    public void setModelo(String modelo){this.modelo = modelo;}
    public void setAño(int año){this.año = año;}
    public void setKm(int km){this.km = km;}
    public void setnBastidor(String nBastidor){this.nBastidor = nBastidor;}

    @Override
    public String toString(){
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", km=" + km +
                ", nBastidor='" + nBastidor + '\'' +
                '}';
    }

}
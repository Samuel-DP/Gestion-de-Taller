package model;

public class Inventario {

    private String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    private int idProveedor;

    public Inventario(String nombreProducto, int cantidad, double precioUnitario, int idProveedor) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario; 
        this.idProveedor = idProveedor;
    }

    public String getNombreProducto() { return nombreProducto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getIdProveedor() { return idProveedor; }
    
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    @Override
    public String toString(){
        return "Inventario{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", idProveedor=" + idProveedor +
                '}';
    }
}

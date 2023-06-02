package Model;

public class Postre {
    
    private String detalle;
    private double precio;

    public Postre() {
    }

    public Postre(String detalle, double precio) {
        this.detalle = detalle;
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

}

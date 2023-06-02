
package Model;

public class Comida {
    
    private String codigo;
    private double precio;
    private String detalle;

    public Comida() {
    }
    
    
    public Comida(String codigo, double precio, String detalle) {
        this.codigo = codigo;
        this.precio = precio;
        this.detalle = detalle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}

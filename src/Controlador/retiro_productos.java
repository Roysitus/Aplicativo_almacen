
package Controlador;

public class retiro_productos {
    
    private String codigo, fecha;
    private int cantidad;

    public retiro_productos(String codigo, String fecha, int cantidad) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}

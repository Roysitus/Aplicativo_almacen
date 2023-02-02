
package Productos;

import Interface.Codigo;

public class Producto implements Codigo{

    public static int getCod() {
        return cod;
    }

    public static void setCod(int aCod) {
        cod = aCod;
    }
    
    private String codigo, nombrePro;
    private int cantidad;
    private double precio;
    private static int cod = 0;

    public Producto(String codigo, String nombrePro, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombrePro = nombrePro;
        this.cantidad = cantidad;
        this.precio = precio;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String generar_codigo() {
        return "COD-"+cod;
    }
    
    
}

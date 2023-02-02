
package dao.interfaces;

import Productos.Producto;
import java.util.List;

public interface interface_producto {
    public boolean crear(Producto u);
    public boolean actualizar(Producto u);
    public boolean borrar(String usuario);
    public List<Producto> obtener();
}

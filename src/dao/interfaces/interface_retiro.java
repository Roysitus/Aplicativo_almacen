
package dao.interfaces;

import Controlador.retiro_productos;
import java.util.List;

public interface interface_retiro {
    public boolean crear(retiro_productos u);
    public boolean actualizar(retiro_productos u);
    public boolean borrar(String usuario);
    public List<retiro_productos> obtener();
}

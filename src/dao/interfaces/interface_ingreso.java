
package dao.interfaces;

import Controlador.ingreso_productos;
import java.util.List;

public interface interface_ingreso {
    public boolean crear(ingreso_productos u);
    public boolean actualizar(ingreso_productos u);
    public boolean borrar(String usuario);
    public List<ingreso_productos> obtener();
}

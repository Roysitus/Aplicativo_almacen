
package dao.interfaces;

import User_Admin.Administrador;
import java.util.List;

public interface interface_administrador {
    public boolean crear(Administrador u);
    public boolean actualizar(Administrador u);
    public boolean borrar(String usuario);
    public List<Administrador> obtener();
}

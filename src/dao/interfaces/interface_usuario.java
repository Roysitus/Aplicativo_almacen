
package dao.interfaces;

import User_Admin.Usuario;
import java.util.List;

public interface interface_usuario {
    public boolean crear(Usuario u);
    public boolean actualizar(Usuario u);
    public boolean borrar(String usuario);
    public List<Usuario> obtener();
}

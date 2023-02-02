
package dao.clases;

import Conexion.Conectar;
import User_Admin.Usuario;
import dao.interfaces.interface_usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioCAD extends Conectar implements interface_usuario{
    @Override
    public boolean crear(Usuario u) {
        int tamaño = obtener().size();
        u.setCuenta(tamaño);
        u.setUser(u.generar());
        System.out.println(""+u.getUser());
        conectar();
        String sql = "insert into usuario (user , contraseña, peticiones, habilitado, nombre, apellido, edad) values('" + u.getUser() + "','" + u.getContraseña() + "','" + u.getPeticiones() + 
                "','" + u.getHabilitado()+ "','" + u.getNombre()+ "','" + u.getApellido()+ "','" + u.getEdad()+ "')";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Usuario u) {
        conectar();
        String sql = "update usuario set contraseña='" + u.getContraseña() + "', nombre='" + u.getNombre() + "', apellido='" + u.getApellido() + "', habilitado='" + u.getHabilitado()+ "', peticiones='" + u.getPeticiones()+ "', edad='" + u.getEdad()+
                "' where user ='" + u.getUser()+ "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from usuario where user='" + usuario + "'";
        try {
            Statement st = conexion.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Usuario> obtener() {
        conectar();
        List<Usuario> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `usuario`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario d = new Usuario(rs.getString("user"), rs.getString("contraseña"), rs.getInt("peticiones"), rs.getString("habilitado"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(usuarioCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Usuario buscar(String usuario){
        for(Usuario ad : obtener()){
            if(ad.getUser().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}

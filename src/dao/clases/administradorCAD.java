
package dao.clases;

import Conexion.Conectar;
import User_Admin.Administrador;
import dao.interfaces.interface_administrador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class administradorCAD extends Conectar implements interface_administrador{
    @Override
    public boolean crear(Administrador u) {
        int tamaño = obtener().size();
        u.setCuenta(tamaño);
        u.setAdmin(u.generar());
        System.out.println(""+u.getAdmin());
        conectar();
        String sql = "insert into administrador (admin , contraseña, peticiones, habilitado, nombre, apellido, edad) values('" + u.getAdmin() + "','" + u.getContraseña() + "','" + u.getPeticiones() + 
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
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(Administrador u) {
        conectar();
        String sql = "update administrador set contraseña='" + u.getContraseña() + "', nombre='" + u.getNombre() + "', apellido='" + u.getApellido() + "', habilitado='" + u.getHabilitado()+ "', peticiones='" + u.getPeticiones()+ "', edad='" + u.getEdad()+
                "' where admin ='" + u.getAdmin()+ "'";
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
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from administrador where admin='" + usuario + "'";
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
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Administrador> obtener() {
        conectar();
        List<Administrador> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `administrador`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Administrador d = new Administrador(rs.getString("admin"), rs.getString("contraseña"), rs.getInt("peticiones"), rs.getString("habilitado"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(administradorCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public Administrador buscar(String usuario){
        for(Administrador ad : obtener()){
            if(ad.getAdmin().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}

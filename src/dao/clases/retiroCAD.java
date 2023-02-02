
package dao.clases;

import Conexion.Conectar;
import Controlador.retiro_productos;
import dao.interfaces.interface_retiro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class retiroCAD extends Conectar implements interface_retiro{
    @Override
    public boolean crear(retiro_productos u) {
        conectar();
        String sql = "insert into retiro (codigo , fecha, cantidad) values('" + u.getCodigo() + "','" + u.getFecha()+ 
                "','" + u.getCantidad()+ "')";
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
                Logger.getLogger(productoCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean actualizar(retiro_productos u) {
        conectar();
        String sql = "update retiro set fecha='" + u.getFecha() + "', cantidad='" + u.getCantidad() + 
                "' where codigo ='" + u.getCodigo()+ "'";
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
                Logger.getLogger(productoCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean borrar(String usuario) {
        conectar();
        String sql = "delete from retiro where codigo='" + usuario + "'";
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
                Logger.getLogger(productoCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<retiro_productos> obtener() {
        conectar();
        List<retiro_productos> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `retiro`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                retiro_productos d = new retiro_productos(rs.getString("codigo"), rs.getString("fecha"), rs.getInt("cantidad"));
                consumos.add(d);
            }
        } catch (Exception e) {
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(productoCAD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return consumos;
    }
    
    public retiro_productos buscar(String usuario){
        for(retiro_productos ad : obtener()){
            if(ad.getCodigo().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}

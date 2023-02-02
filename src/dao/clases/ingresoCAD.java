
package dao.clases;

import Conexion.Conectar;
import Controlador.ingreso_productos;
import dao.interfaces.interface_ingreso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ingresoCAD extends Conectar implements interface_ingreso{
    @Override
    public boolean crear(ingreso_productos u) {
        conectar();
        String sql = "insert into ingreso (codigo , fecha, cantidad) values('" + u.getCodigo() + "','" + u.getFecha()+ 
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
    public boolean actualizar(ingreso_productos u) {
        conectar();
        String sql = "update ingreso set fecha='" + u.getFecha() + "', cantidad='" + u.getCantidad() + 
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
        String sql = "delete from ingreso where codigo='" + usuario + "'";
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
    public List<ingreso_productos> obtener() {
        conectar();
        List<ingreso_productos> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `ingreso`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ingreso_productos d = new ingreso_productos(rs.getString("codigo"), rs.getString("fecha"), rs.getInt("cantidad"));
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
    
    public ingreso_productos buscar(String usuario){
        for(ingreso_productos ad : obtener()){
            if(ad.getCodigo().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
}

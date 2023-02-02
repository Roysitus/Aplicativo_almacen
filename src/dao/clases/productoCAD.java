
package dao.clases;

import Conexion.Conectar;
import Productos.Producto;
import dao.interfaces.interface_producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class productoCAD extends Conectar implements interface_producto{
    @Override
    public boolean crear(Producto u) {
        int tamaño = obtener().size();
        u.setCod(tamaño);
        u.setCodigo(u.generar_codigo());
        System.out.println(""+u.getCodigo());
        conectar();
        String sql = "insert into producto (codigo , nombrepro, cantidad, precio) values('" + u.getCodigo() + "','" + u.getNombrePro() + "','" + u.getCantidad() + 
                "','" + u.getPrecio()+ "')";
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
    public boolean actualizar(Producto u) {
        conectar();
        String sql = "update producto set nombrepro='" + u.getNombrePro() + "', cantidad='" + u.getCantidad() + "', precio='" + u.getPrecio() +
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
        String sql = "delete from producto where codigo='" + usuario + "'";
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
    public List<Producto> obtener() {
        conectar();
        List<Producto> consumos = new ArrayList<>();
        
        String sql = "SELECT * FROM `producto`";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto d = new Producto(rs.getString("codigo"), rs.getString("nombrepro"), rs.getInt("cantidad"), rs.getDouble("precio"));
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
    
    public Producto buscar(String usuario){
        for(Producto ad : obtener()){
            if(ad.getCodigo().equals(usuario)){
                return ad;
            }
        }
        return null;
    }
    public void Ordenar_nombre_producto() {
        obtener().sort(new ordena1());
    }
    
    public void Ordenar_precio_producto(){
        obtener().sort(new ordena3());
    }
}
class ordena1 implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombrePro().compareTo(o2.getNombrePro());
    }
    
}

class ordena3 implements Comparator<Producto> {

    @Override
    public int compare(Producto o1, Producto o2) {
        if (o1.getPrecio() > o2.getPrecio()) {
            return 1;
        } else if (o1.getPrecio() < o2.getPrecio()) {
            return -1;
        } else {
            return 0;
        }
    }

}


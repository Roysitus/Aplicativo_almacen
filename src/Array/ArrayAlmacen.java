
package Array;

import Productos.Producto;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayAlmacen {
    
    private static ArrayList<Producto> almacen = new ArrayList();
    static boolean unico = true;
    
    public ArrayAlmacen() {
//        if(unico){
//            almacen.add(new Producto("Manzana", 150, 2.3));
//            almacen.add(new Producto("Pera", 300, 5.6));
//            almacen.add(new Producto("Platano", 120, 7.1));
//            almacen.add(new Producto("Naranja", 600, 4.8));
//            almacen.add(new Producto("Pepino", 420, 3.6));
//            almacen.add(new Producto("Mandarina", 900, 1.7));
//            almacen.add(new Producto("Mango", 100, 9.5));
//            almacen.add(new Producto("Chirimoya", 160, 8.9));
//            unico = false;
//        }
    }
    
    public void agregar_producto(Producto e){
        almacen.add(e);
    }
    
    public void remover(int pos){
        almacen.remove(pos);
    }
    
    public int tamaño(){
        return almacen.size();
    }
    
    public Producto obtener(int pos){
        return almacen.get(pos);
    }
    
    public Producto buscar_producto(String cod_prod){
        for (Producto p : almacen) {
            if(p.getCodigo().equals(cod_prod)){
                return p;
            }
        }
        return null;
    }
    
    public int buscar_pos_producto(String cod_prod){
        int pos = -1 , i = 0;
        for (Producto p : almacen) {
            if(p.getCodigo().equals(cod_prod)){
                return i;
            }
            i++;
        }
        return pos;
    }
    
    public void Ordenar_nombre_producto() {
        almacen.sort(new ordena1());
    }
    
    public void Ordenar_precio_producto(){
        almacen.sort(new ordena3());
    }
    
    public static ArrayList<Producto> getAlmacen() {
        return almacen;
    }

    public static void setAlmacen(ArrayList<Producto> aAlmacen) {
        almacen = aAlmacen;
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

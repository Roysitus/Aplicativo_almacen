
package Conexion;

import dao.clases.administradorCAD;
import dao.clases.usuarioCAD;

public class Main {

    public static void main(String[] args) {
        Conectar c = new Conectar();
        c.conectar();
        usuarioCAD x = new usuarioCAD();
        System.out.println(""+x.obtener().size());
    }
    
}

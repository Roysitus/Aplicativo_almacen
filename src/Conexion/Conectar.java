
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conectar {
    private String url = "jdbc:mysql://localhost:3306/bd_almacen";
    private String usuario = "root";
    private String password = "";
    protected com.mysql.jdbc.Connection conexion;
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(url,usuario,password);
            System.out.println("Conexion Iniciada");
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
                
    }
}

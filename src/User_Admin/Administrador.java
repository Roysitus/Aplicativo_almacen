
package User_Admin;

public class Administrador extends Persona{

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int aCuenta) {
        cuenta = aCuenta;
    }

    private String admin , contraseña;
    private int peticiones;
    private String habilitado;
    private static int cuenta = 0;

    public Administrador(String admin, String contraseña, int peticiones, String habilitado, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.admin = admin;
        this.contraseña = contraseña;
        this.peticiones = peticiones;
        this.habilitado = habilitado;
    }


    @Override
    public String generar() {
        return "ADMIN-"+cuenta;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(int peticiones) {
        this.peticiones = peticiones;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    
    
    
}

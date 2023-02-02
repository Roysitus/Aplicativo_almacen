package User_Admin;

public class Usuario extends Persona {

    private String user, contraseña;
    private int peticiones;
    private String habilitado;
    private static int cuenta = 0;

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int aCuenta) {
        cuenta = aCuenta;
    }

    public Usuario(String user, String contraseña, int peticiones, String habilitado, String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.user = user;
        this.contraseña = contraseña;
        this.peticiones = peticiones;
        this.habilitado = habilitado;
    }

    @Override
    public String generar() {
        return "USER-" + cuenta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

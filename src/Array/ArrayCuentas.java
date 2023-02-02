package Array;

import Interface.Array;
import User_Admin.*;
import java.util.ArrayList;

public class ArrayCuentas implements Array{

    private static ArrayList<Persona> cuentas = new ArrayList();
    static boolean unico = true;

    public ArrayCuentas() {
//        if (unico) {
//            cuentas.add(new Administrador("12345", "Linux", "Centro", 19));
//            cuentas.add(new Administrador("bask3t", "Windows", "Oeste", 19));
//            cuentas.add(new Administrador("duki", "Android", "Sureste", 19));
//            cuentas.add(new Usuario("12345", "Josesiño", "Centro", 19));
//            cuentas.add(new Usuario("54321", "Miguelito", "Sur", 20));
//            cuentas.add(new Usuario("98416", "Samuelito", "Este", 21));
//            unico = false;
//        }
    }

    public void agregar_usuario(Usuario u) {
        cuentas.add(u);
    }

    public void agregar_administrador(Administrador a) {
        cuentas.add(a);
    }

    @Override
    public int tamaño() {
        return cuentas.size();
    }

    public Persona obtener(int posicion) {
        return cuentas.get(posicion);
    }

    public void remover(int posicion) {
        cuentas.remove(posicion);
    }

    public Usuario buscar_usuario(String user) {
        for (Persona p : cuentas) {
            if (p instanceof Usuario) {
                if (((Usuario) p).getUser().equals(user)) {
                    return (Usuario) p;
                }
            }
        }
        return null;
    }

    public Administrador buscar_admiAdministrador(String admin) {
        for (Persona p : cuentas) {
            if (p instanceof Administrador) {
                if (((Administrador) p).getAdmin().equals(admin)) {
                    return (Administrador) p;
                }
            }
        }
        return null;
    }

    public int buscar_posicion_usuario(String user) {
        int pos = -1, i = 0;
        for (Persona p : cuentas) {
            if (p instanceof Usuario) {
                if (((Usuario) p).getUser().equals(user)) {
                    return i;
                }
            }
            i++;
        }
        return pos;
    }

    public int buscar_posicion_administrador(String admin) {
        int pos = -1, i = 0;
        for (Persona p : cuentas) {
            if (p instanceof Administrador) {
                if (((Administrador) p).getAdmin().equals(admin)) {
                    return i;
                }
            }
            i++;
        }
        return pos;
    }

    public static ArrayList<Persona> getCuentas() {
        return cuentas;
    }

    public static void setCuentas(ArrayList<Persona> aCuentas) {
        cuentas = aCuentas;
    }

}

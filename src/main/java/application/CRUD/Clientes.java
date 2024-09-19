package application.CRUD;

import application.domain.Usuario;

import java.util.ArrayList;

public class Clientes {
    public static final double TARIFAPREMIUM = 35.5;
    public static final double TARIFANOPREMIUM = 20.5;

    public boolean annadirUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
        if (usuarios.contains(usuario)) return false;
        usuarios.add(usuario);
        return true;
    }

    /*
    En este codigo buscaremos un usuario dentro del listado de usuarios de la aplicación en funcion de su correo de gmail.
    Para ello, recorremos el array con stream y buscamos mediante filter un usuario que tenga el mismo identificador.
    Si no lo encontramos, devolvemos null.
    */
    public Usuario buscarUsuario(ArrayList<Usuario> usuarios, String gmail) {
        return usuarios.stream()
                .filter(usuario -> usuario.getIdentificador().equalsIgnoreCase(gmail))
                .findFirst()
                .orElse(null);
    }

    public Double totalIngreso(ArrayList<Usuario> usuarios) {
        return usuarios.stream()
                .mapToDouble(usuario -> {
                    double tarifaPlana = usuario.isPremium() ? TARIFAPREMIUM : TARIFANOPREMIUM;
                    return tarifaPlana - usuario.getDescuento();
                }).sum();
    }
}

package application.CRUD;

import application.domain.Cliente;
import application.domain.Usuario;

import java.util.ArrayList;

public class Clientes {

    public boolean annadirUsuario(ArrayList<Cliente> usuarios, Usuario usuario) {
        if (usuarios.contains(usuario)) return false;
        usuarios.add(usuario);
        return true;
    }

    public Usuario buscarUsuario(ArrayList<Cliente> usuarios, String gmail) {
        return (Usuario) usuarios.stream()
                .filter(cliente -> cliente.getIdentificador().equals(gmail))
                .findFirst()
                .orElse(null);

    }

    public Double totalIngreso(ArrayList<Cliente> usuarios) {
        return 0.0;
    }
}

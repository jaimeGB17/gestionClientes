package application.view.comand;

import application.CRUD.Clientes;
import application.domain.Cliente;
import application.domain.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Clientes clientes = new Clientes();

    public static void main(String[] args) {
        ArrayList<Cliente> usuarios = new ArrayList<Cliente>();
        int selectedOption = -1;
        do {
            try {
                System.out.println("Elige opción:");
                System.out.println("1. - Añadir Usuario");
                System.out.println("2. - Buscar Usuario");
                System.out.println("3. - Total Ingresos");
                System.out.println("0. - Salir");

                selectedOption = scanner.nextInt();
                System.out.println(selectedOption);

                switch (selectedOption) {

                    case 1: //crear usuario
                        String identificador, contrasenna;
                        int numpremium;
                        double descuento;
                        boolean premium = false;
                        System.out.println("Escriba aquí su correo electrónico.");
                        identificador = scanner.next();
                        System.out.println("Escriba aquí su contraseña.");
                        contrasenna = scanner.next();
                        System.out.println("Escriba aquí el descuento. (2,5)");
                        descuento = scanner.nextDouble();
                        System.out.println("¿Eres premium? 1/0");
                        numpremium = scanner.nextInt();
                        do {
                            if (numpremium == 1) {
                                premium = true;
                            } else {
                                System.out.println("no es ni 1 ni 0");
                                System.out.println("¿Eres premium? 1/0");
                                numpremium = scanner.nextInt();
                            }
                        } while (numpremium != 0 && numpremium != 1);

                        Usuario usuario = new Usuario(identificador, contrasenna, descuento, premium);
                        boolean compruebaAnnadir = clientes.annadirUsuario(usuarios, usuario);
                        if (!compruebaAnnadir) {
                            System.out.println("error al insertar usuario");
                        } else {
                            System.out.println("Usuario creado correctamente");
                        }
                        break;

                    case 2: //buscar usuario

                        String gmail;
                        System.out.println("Escriba aquí el correo del usuario que busca.");
                        gmail = scanner.next();
                        Usuario usuarioBuscado = clientes.buscarUsuario(usuarios, gmail);
                        if (usuarioBuscado == null) {
                            System.out.println("Usuario no encontrado");
                        } else {
                            System.out.println(usuarioBuscado);
                        }
                        break;

                    case 3: //total ingreso

                        break;

                    default:

                }

            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (selectedOption != 0);


    }
}

package application.view;

import application.CRUD.Clientes;
import application.domain.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //La clase escaner para poder recibir datos del teclado.
    static Scanner scanner = new Scanner(System.in);
    // conectamos al CRUD clientes para poder hacer tanto las inserciones como busquedas, etc de la lista de usuaios.
    static Clientes clientes = new Clientes();
    //La lista de de objetos de tipo Usuario.
    static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicación de repaso de Java modo comandos.");
        int selectedOption = -1;
        do {
            try {
                selectedOption = displayMenu();
                switch (selectedOption) {
                    case 1: //crear usuario
                        annadirUsuario();
                        break;
                    case 2: //buscar usuario
                        buscarUsuario();
                        break;
                    case 3: //total ingreso
                        totalIngreso();
                        break;
                    default:
                        System.out.println("Por favor atengase las opciones.");
                }
            } catch (Exception e) {
                System.out.println("Error");
            }
        } while (selectedOption != 0);

        System.out.println("Adios");
    }

    /*
    En este metodo mostramos el menu con las opciones que el usuario puede realizar.
     */
    static public int displayMenu() {
        System.out.println();
        System.out.println("Elige una opción:");
        System.out.println("1. - Añadir Usuario");
        System.out.println("2. - Buscar Usuario");
        System.out.println("3. - Total Ingresos");
        System.out.println("0. - Salir");
        System.out.println();
        return Integer.parseInt(scanner.next());
    }

    /*
    En este metodo, pedimos todos los datos para introducir un usuario
     */
    static public void annadirUsuario() {
        String identificador, contrasenna;
        double descuento;
        boolean premium;

        System.out.println("Escriba aquí su correo electrónico.");
        identificador = scanner.next();

        System.out.println("Escriba aquí su contraseña.");
        contrasenna = scanner.next();

        System.out.println("Escriba aquí el descuento. (Ej: 2,5)");
        descuento = Double.parseDouble(scanner.next());

        System.out.println("¿Eres premium? (Si=>1\tNo=>0)");
        premium = Boolean.parseBoolean(scanner.next());

        Usuario usuario = new Usuario(identificador, contrasenna, descuento, premium);
        boolean compruebaAnnadir = clientes.annadirUsuario(usuarios, usuario);
        System.out.println();
        if (!compruebaAnnadir) {
            System.out.println("error al insertar usuario");
        } else {
            System.out.println("Usuario creado correctamente");
        }
    }

    /*
     Este metodo se encarga de pedirte un correo para buscar dicho usuario en la lista de usuarios.
     */
    static public void buscarUsuario() {
        String gmail;
        System.out.println("Escriba aquí el correo del usuario que busca.");
        gmail = scanner.next();
        Usuario usuarioBuscado = clientes.buscarUsuario(usuarios, gmail);
        System.out.println();
        if (usuarioBuscado == null) {
            System.out.println("Usuario no encontrado");
        } else {
            System.out.println(usuarioBuscado);
        }
    }

    /*
    Este metodo muestra en pantalla el total ingreso que recibe del CRUD
     */
    static public void totalIngreso() {
        double totalIngresos = clientes.totalIngreso(usuarios);
        System.out.println();
        System.out.println("El total de ingresos es:" + totalIngresos);
    }
}

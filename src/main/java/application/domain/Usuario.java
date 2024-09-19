package application.domain;

public class Usuario extends Cliente {
    private boolean premium;

    public Usuario() {
    }

    public Usuario(String identificador, String contrasenna, Double descuento, boolean premium) {
        super(identificador, contrasenna, descuento);
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "identificador = " + getIdentificador() +
                ", contraseña = " + getContrasenna() +
                ", descuento =" + getContrasenna() +
                ", premium = " + premium +
                '}';
    }

    @Override
    public int compareTo(Cliente c) {
        if (this.getIdentificador().equalsIgnoreCase(c.getIdentificador())) {
            return 1;
        } else {
            return 0;
        }
    }

}

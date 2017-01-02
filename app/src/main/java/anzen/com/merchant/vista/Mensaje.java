package anzen.com.merchant.vista;

/**
 * Created by Work on 02/01/17.
 */
public class Mensaje {
    String de, asunto, mensaje;

    public Mensaje(String s, String s1, String s2) {
        de = s;
        asunto = s1;
        mensaje = s2;
    }

    public String getDe() {
        return de;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }
}

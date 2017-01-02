package anzen.com.merchant;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anzen.com.merchant.vista.FragmentDetalle;
import anzen.com.merchant.vista.FragmentListado;
import anzen.com.merchant.vista.Mensaje;

public class MainActivity extends FragmentActivity implements
        FragmentListado.MensajesListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // De nimos el fragmento del listado mediante
        // referencia a su id
        FragmentListado frgListado
                = (FragmentListado) getSupportFragmentManager()
                .findFragmentById(R.id.FrgListado);
        // Establecemos el listener del listado
        frgListado.setMensajesListener(this);
    }

    // Se implementa el método onMensajeSeleccionado del listener
    // MensajesListener
    @Override
    public void onMensajeSeleccionado(Mensaje mensaje) {
        // Buscamos si Android está mostrando el detalle del mensaje
        // buscando si está de nido el fragmento de detalle

        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById
                        (R.id.FrgDetalle) != null);
// Si se ven los dos fragmentos entonces cuando el usuario haga
// clic en un mensaje se muestra su detalle
        if (hayDetalle) {
            ((FragmentDetalle) getSupportFragmentManager()
                    .findFragmentById(R.id.FrgDetalle)).mostrarDetalle(
                    mensaje.getMensaje());
        }
// Si no existe el fragmento de detalle lanzamos la actividad de
// detalle con un Intent pasando el texto como una propiedad en
// éste
        else {
            Intent i = new Intent(this, Detalle.class);
            i.putExtra(Detalle.EXTRA_TEXTO,mensaje.getMensaje());
                    startActivity(i);
        }
    }

}

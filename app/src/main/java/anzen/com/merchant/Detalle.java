package anzen.com.merchant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import anzen.com.merchant.vista.FragmentDetalle;

public class Detalle extends AppCompatActivity {
    // De nimos una constante que usaremos en Intent para pasar la
    // información al fragmento
    public static  final String EXTRA_TEXTO ="EXTRA_TEXTO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Buscamos el fragmento de detalle que es un fragmento
        FragmentDetalle detalle =
                (FragmentDetalle)getSupportFragmentManager()
                        . findFragmentById(R.id.FrgDetalle);
        // Cargamos el texto del detalle en este fragmento
        detalle.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}

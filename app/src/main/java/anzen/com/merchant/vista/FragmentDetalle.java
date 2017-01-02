package anzen.com.merchant.vista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import anzen.com.merchant.R;

/**
 * Created by Work on 02/01/17.
 */

// Fragmento que de ne el detalle del Mensaje
public class FragmentDetalle extends Fragment {
    // In amos la Vista
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_detalle, container,
                false);
    }

    // De nimos el método que asigna el texto del cuerpo del mensaje
    public void mostrarDetalle(String texto) {
        TextView cuerpoMensaj =
                (TextView) getView().findViewById(R.id.cuerpoMensaj);
        cuerpoMensaj.setText(texto);
    }
}
package anzen.com.merchant.vista;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import anzen.com.merchant.R;

/**
 * Created by Work on 02/01/17.
 */

public class FragmentListado extends Fragment {
    // Matriz que simula un listado de mensajes
    private Mensaje[] datos =
            new Mensaje[]{
                    new Mensaje("Pedro del Bosque", "Petición de información",
                            "Hola.\n\n Por favor, remíteme la información lo antes posible.\n\n ¡Gracias!"),
                    new Mensaje("Alicia Navas", "Hola!", "Hola!\n\n Te espero en la  esta.\n\n Besos!"),
                    new Mensaje("Daniel Fernández", "Sobre viaje", "¿Al  nal vienes el  n de semana?\n\n Saludos"),
                    new Mensaje("Jaime del Monte", "Más trabajo", "Por favor, ponte en contacto conmigo.\n\n Gracias")};
    // ListView donde mostramos los mensajes
    private ListView listado;
    // Listener que detecta cuándo un usuario hace clic sobre un mensaje
    private MensajesListener listener;

    // Método equivalente al onCreate() de una Actividad
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Devolvemos el xml in ado que de ne el listado
        return inflater.inflate(R.layout.fragmento_listado, container,
                false);
    }

    // Método que se ejecuta cuando la Actividad
// contenedora del fragmento está completamente creada
// Aquí es donde debemos asociar el adaptador al listado
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        // Buscamos el listado del layout
        listado = (ListView) getView().findViewById(R.id.listado);
// Asociamos el adaptador 183 listado.setAdapter(new AdaptadorMensajes(this));
// De nimos el evento onClic del listado
        listado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int
                    pos, long id) {
                if (listener != null) {
                    // Pasamos como parámetro la posición del elemento
                    // seleccionado
                    listener.onMensajeSeleccionado(
                            (Mensaje) listado.getAdapter().getItem(pos));
                }
            }
        }); // end onItemClick
        AdaptadorMensajes ad= new AdaptadorMensajes(this);
        listado.setAdapter(ad);

    }

    // Clase que de ne el adaptador del Listado
    class AdaptadorMensajes extends ArrayAdapter<Mensaje> {
        // Variable para guardar el contexto de la Actividad
        Activity contexto;

        // Constructor del Adaptador
        AdaptadorMensajes(Fragment context) {
            // Usamos el layout correspondiente del listado
            super(context.getActivity(), R.layout.listitem_mensaje, datos);
            this.contexto = context.getActivity();
        }
// Método que de ne la forma de dibujar de las opciones

        public View getView(int position, View convertView, ViewGroup
                parent) {
            // Se in a el layout y se completa con información las Vistas
            // internas de la opción.
            // Atención: en el curso de Iniciación vimos que es
            // conveniente reutilizar las vistas dentro de un listado.
            // Por simpli cación del código fuente no lo hemos hecho.
            LayoutInflater inflater = contexto.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_mensaje, null);
            TextView lblDe = (TextView) item.findViewById(R.id.lblDe);
            lblDe.setText(datos[position].getDe());
            TextView lblAsunto = (TextView)item.findViewById(R.id.lblAsunto);
            lblAsunto.setText(datos[position].getAsunto());
            return (item);
        }
    }

    // De nimos una interfaz que se implementará en la clase principal
// de la aplicación y que tendrá en cuenta el tamaño de la pantalla
// disponible
    public interface MensajesListener {
        void onMensajeSeleccionado(Mensaje mensaje);
    }

    public void setMensajesListener(MensajesListener listener) {
        this.listener = listener;
    }
}

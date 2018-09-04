package ar.edu.utn.frsf.isi.dam.listsamples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Pelicula;

public class PeliculaAdapter<Pelicula> extends ArrayAdapter<Pelicula>{
    Context ctx;
    public PeliculaAdapter(Context actividad, List<Pelicula> lista){
        super(actividad,0,lista);
        this.ctx=actividad;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View fila02 = inflater.inflate(R.layout.fila02,parent,false);
        Pelicula p = super.getItem(position);

        TextView tvTitulo = (TextView) fila02.findViewById(R.id.tvTitulo);
        return fila02;
    }
}

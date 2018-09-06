package ar.edu.utn.frsf.isi.dam.listsamples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Pelicula;

public class PeliculaAdapterReciclaHolder extends ArrayAdapter<Pelicula>{
    Context ctx;
    public PeliculaAdapterReciclaHolder(Context actividad, List<Pelicula> lista){
        super(actividad,0,lista);
        this.ctx=actividad;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View fila02 = convertView;
        if(fila02== null) {
            fila02 = inflater.inflate(R.layout.fila02, parent, false);
        }
        PeliculaViewHolder holder = (PeliculaViewHolder) fila02.getTag();
        if(holder==null){
            holder = new PeliculaViewHolder(fila02);
            fila02.setTag(holder);
        }

        Pelicula peli = (Pelicula) super.getItem(position);

       // TextView tvTitulo = (TextView) fila02.findViewById(R.id.tvTitulo);
       // TextView tvCalif= (TextView) fila02.findViewById(R.id.tvCalificacion);
       // TextView tvGenero= (TextView) fila02.findViewById(R.id.tvGenero);
       // ImageView imgFavorito = (ImageView) fila02.findViewById(R.id.esFavorita);

        if(peli.getFavorita()){
            holder.imgFav.setImageResource(android.R.drawable.star_big_on);
        }else{
            holder.imgFav.setImageResource(android.R.drawable.star_big_off);
        }
        holder.tvTitulo.setText(peli.getNombre());
        holder.tvCalif.setText(" Puntaje: "+peli.getCalificacion());
        holder.tvGenero.setText(peli.getGenero().getNombre());
        return fila02;
    }
}

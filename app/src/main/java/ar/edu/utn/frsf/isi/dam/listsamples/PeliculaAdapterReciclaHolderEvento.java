package ar.edu.utn.frsf.isi.dam.listsamples;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Pelicula;

public class PeliculaAdapterReciclaHolderEvento extends ArrayAdapter<Pelicula>{
    Context ctx;
    public PeliculaAdapterReciclaHolderEvento(Context actividad, List<Pelicula> lista){
        super(actividad,0,lista);
        this.ctx=actividad;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View fila02 = convertView;
        if(fila02== null) {
            fila02 = inflater.inflate(R.layout.fila03, parent, false);
        }
        PeliculaViewHolderRating holder = (PeliculaViewHolderRating) fila02.getTag();
        if(holder==null){
            holder = new PeliculaViewHolderRating(fila02);
            holder.tvCalif.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    Integer pos = (Integer)ratingBar.getTag();
                    Log.d("EJEMPLOS",pos+ " == "+ rating);
                    getItem(pos).setCalificacion((int)rating);
                }
            });
            fila02.setTag(holder);
        }

        Pelicula peli = (Pelicula) super.getItem(position);

        if(peli.getFavorita()){
            holder.imgFav.setImageResource(android.R.drawable.star_big_on);
        }else{
            holder.imgFav.setImageResource(android.R.drawable.star_big_off);
        }
        holder.tvTitulo.setText(peli.getNombre());
        holder.tvCalif.setTag(position);
        holder.tvCalif.setRating(peli.getCalificacion());
        holder.tvGenero.setText(peli.getGenero().getNombre());
        return fila02;
    }
}

package ar.edu.utn.frsf.isi.dam.listsamples;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Pelicula;

public class PeliculaReyclerAdapter extends RecyclerView.Adapter<PeliculaReyclerAdapter.MyPeliculaHolder> {
private List<Pelicula> mDataset;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class MyPeliculaHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    ImageView imgFav;
    TextView tvTitulo;
    //TextView tvCalif;
    TextView tvGenero;
    RatingBar tvCalif;

    public MyPeliculaHolder(View base) {
        super(base);
        this.imgFav = (ImageView) base.findViewById(R.id.esFavorita);
        this.tvTitulo = (TextView) base.findViewById(R.id.tvTitulo);
        this.tvCalif = (RatingBar) base.findViewById(R.id.tvCalificacion);
        this.tvGenero= (TextView) base.findViewById(R.id.tvGenero);
    }
}

    // Provide a suitable constructor (depends on the kind of dataset)
    public PeliculaReyclerAdapter(List<Pelicula> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PeliculaReyclerAdapter.MyPeliculaHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila03, parent, false);
        MyPeliculaHolder vh = new MyPeliculaHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyPeliculaHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Pelicula peli =  mDataset.get(position);
        if(peli.getFavorita()){
            holder.imgFav.setImageResource(android.R.drawable.star_big_on);
        }else{
            holder.imgFav.setImageResource(android.R.drawable.star_big_off);
        }
        holder.tvTitulo.setText(peli.getNombre());
        holder.tvGenero.setText(peli.getGenero().getNombre());
        holder.tvCalif.setTag(position);
        holder.tvCalif.setRating(peli.getCalificacion());
        holder.tvCalif.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Integer pos = (Integer)ratingBar.getTag();
                Log.d("EJEMPLOS",pos+ " == "+ rating);
                mDataset.get(pos).setCalificacion((int)rating);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

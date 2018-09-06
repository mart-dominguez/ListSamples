package ar.edu.utn.frsf.isi.dam.listsamples;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class PeliculaViewHolderRating {
    ImageView imgFav;
    TextView tvTitulo;
    //TextView tvCalif;
    TextView tvGenero;
    RatingBar tvCalif;

    PeliculaViewHolderRating(View base) {
        this.imgFav = (ImageView) base.findViewById(R.id.esFavorita);
        this.tvTitulo = (TextView) base.findViewById(R.id.tvTitulo);
        this.tvCalif = (RatingBar) base.findViewById(R.id.tvCalificacion);
        this.tvGenero= (TextView) base.findViewById(R.id.tvGenero);
    }

}

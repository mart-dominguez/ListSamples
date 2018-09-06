package ar.edu.utn.frsf.isi.dam.listsamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Genero;
import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Pelicula;

public class Ejemplo02Recycler extends AppCompatActivity {

    private ArrayAdapter<Pelicula> peliculaAdapter;
    private ArrayAdapter<Genero> adapterGenero;

    private TextView tvGenero;
    private TextView tvPelicula;

    private Spinner spinner;
    private ListView listaPeliculas;
    private Button btnFinalizar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo02_recycler);
        //listaPeliculas = (ListView) findViewById(R.id.listaPeliculas02);
        spinner = (Spinner) findViewById(R.id.spinnerGenero02);
        tvGenero = (TextView) findViewById(R.id.generoSeleccionado02);
        tvPelicula = (TextView) findViewById(R.id.peliculaSeleccionada02);

        //peliculaAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,Pelicula.lista());
        //peliculaAdapter = new ArrayAdapter(this,R.layout.fila1,R.id.textoFila1,Pelicula.lista());
        //peliculaAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,Pelicula.lista());
        //peliculaAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,Pelicula.lista());
//        peliculaAdapter = new PeliculaAdapter(this,Pelicula.lista());
        //peliculaAdapter = new PeliculaAdapterReciclaHolderEvento(this,Pelicula.lista());

       // listaPeliculas.setAdapter(peliculaAdapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.recylcerPeliculas02);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new PeliculaReyclerAdapter(Pelicula.lista());
        mRecyclerView.setAdapter(mAdapter);

        adapterGenero = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Genero.lista());
        adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterGenero);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvGenero.setText("Seleccionado: "+adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvGenero.setText("seleccione un genero");

            }
        });

        /*
        listaPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pelicula peli = (Pelicula) adapterView.getItemAtPosition(i);
                tvPelicula.setText(peli.getNombre()+" <"+peli.getGenero()+"> Puntuacion: "+peli.getCalificacion());
            }
        });
         */
        btnFinalizar = (Button) findViewById(R.id.btnFinSeleccion02);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray peliculasSeleccionadas = listaPeliculas.getCheckedItemPositions();
                int cantidadFilasLista = listaPeliculas.getCount();
                for(int i=0;i<cantidadFilasLista;i++){
                    if(peliculasSeleccionadas.get(i)) {
                        Toast.makeText(Ejemplo02Recycler.this,"Agregar a favoritos "+listaPeliculas.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}

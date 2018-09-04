package ar.edu.utn.frsf.isi.dam.listsamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import ar.edu.utn.frsf.isi.dam.listsamples.modelo.Genero;

public class Ejemplo01Spinner extends AppCompatActivity {

    private TextView tvGenero;
    private Spinner spinner;
    private ArrayAdapter<Genero> adapterGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo01_spinner);
        spinner = (Spinner) findViewById(R.id.spinnerGenero);
        tvGenero = (TextView) findViewById(R.id.generoSeleccionado);
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
    }


}

package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class Spinner_Activity extends AppCompatActivity {

    private CountryList countries=new CountryList();
    private ArrayAdapter<String> listviewAdapter;
    private ArrayAdapter<String> spinnerAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        // preparazione della ListView per l'elenco delle città
        //in questo modo collego la listview a quella dichiarata nel xml del'activity
        ListView lv=(ListView) findViewById(R.id.cities);
        listviewAdapter=new ArrayAdapter<String>(this, R.layout.row);
        lv.setAdapter(listviewAdapter);

        // preparazione dello Spinner per mostrare l'elenco dei Paesi
        spinnerAdapter=new ArrayAdapter<String>(this, R.layout.row);
        spinnerAdapter.addAll(countries.getCountries());
        Spinner sp=(Spinner) findViewById(R.id.countries);
        sp.setAdapter(spinnerAdapter);
        sp.setOnItemSelectedListener(new GestionClickSpinner());

    }


    //aggiungo l ascoltatore del click sullo spinner
    class GestionClickSpinner implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                                   int arg2, long arg3) {
            TextView txt=(TextView) arg1.findViewById(R.id.rowtext);
            String s=txt.getText().toString();
            updateCities(s);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0)
        { }


        private void updateCities(String country)
        {
            //a seconda del nome della citta passata vado a svuotare la lista delle citta di quel paese
            //e vado ad aggiungere tutte le cita di quel paese
            ArrayList<String> l=(ArrayList<String>)
                    countries.getCitiesByCountry(country);
            listviewAdapter.clear();
            listviewAdapter.addAll(l);
        }
    }


}






package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class GridView_Activity extends AppCompatActivity {

        private GridView gridView;
        String[] citta=new String[]{"Torino","Roma","Milano","Napoli","Firenze"};
        private  Toast toast;

    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.row,citta);
            gridView = (GridView) findViewById(R.id.gridview);
            gridView.setAdapter(adapter);
            //AL SOLITO DICHIARO UNA CLASSE E INSTANZIO L ASCOLTATORE
            gridView.setOnItemClickListener(new GestioneClickGridView());
            toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);

    }


    class GestioneClickGridView implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //toast.cancel();
            toast.setText("Selezionato "+citta[position]);
            toast.show();

        }
    }
}

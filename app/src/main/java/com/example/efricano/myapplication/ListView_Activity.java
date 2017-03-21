package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class ListView_Activity extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        String[] citta=new String[]{"Torino","Roma","Milano","Napoli","Firenze"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.row,citta);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }
}

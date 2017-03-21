package com.example.efricano.myapplication;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by e.fricano on 07/03/2017.
 */

public class Third_Activity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione);

        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Connecting");
        progress.setMessage("Please wait while we connect to devices...");
        progress.show();
        progress.setCancelable(false);
        //ABBIAMO LA CREAZIONE DI UN THREAD CHE VIENE RICHIAMATO SOTTO
        //parte dopo 3 secondi e poi mostra la data
        Runnable progressRunnable = new Runnable() {
            @Override
            public void run() {
                progress.setCancelable(true);
                progress.cancel();
                Intent i = getIntent();
                String data = i.getStringExtra("data");
                TextView t = (TextView) findViewById(R.id.data_settata);
                t.setText("LA DATA INSERITA è :"+ data);
            }
        };
        //DAL GESTORE CHE VA A FAR PARTIRE DOPO 3 SECONDI IL THREAD STESSO, CHE PARTIRà COL SUO METODO RUN
        Handler pdCanceller = new Handler();
        pdCanceller.postDelayed(progressRunnable, 3000);




        //onRequestPermissionsResult(0,permessi_lista,stati);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MyAPP", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MyAPP", "onStop");


    }







}

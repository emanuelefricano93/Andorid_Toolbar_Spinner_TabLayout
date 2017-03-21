package com.example.efricano.myapplication;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by e.fricano on 07/03/2017.
 */

public class Second_Activity  extends AppCompatActivity  {


    final int ID_RICHIESTA_PERMISSION = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent i = getIntent();
        String username = i.getStringExtra("username");
        TextView t2 = (TextView) findViewById(R.id.testo_seconda_pagina2);
        t2.setText("ciao " + username);

        TextView t = (TextView) findViewById(R.id.testo_seconda_pagina);

        int statoPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        t.setText("LO STATO DELLA POSIZIONE E'" + statoPermission);


        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ID_RICHIESTA_PERMISSION);


        statoPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        t.setText("LO STATO DELLA POSIZIONE E'" + statoPermission);


        int[] stati = new int[1];
        stati[0]=statoPermission;

        String [] permessi_lista=new String [1];
        permessi_lista[0]=Manifest.permission.ACCESS_FINE_LOCATION;

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

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MyAPP", "onResume");

        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this, 0, i, 0);

        android.net.Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder n  = new NotificationCompat.Builder(this)
                .setContentTitle("NOTIFICA")
                .setContentText("passaggio in resume")
                .setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pi)
                .setSound(sound);


        //qui stiamo chiedendo un servizio al sistema,chiedendo una notifica
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, n.build());
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        TextView t2 = (TextView) findViewById(R.id.testo_seconda_pagina);
        t2.setText("on resume");

        switch (requestCode) {
            case ID_RICHIESTA_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission concessa: eseguiamo il codice
                    TextView t = (TextView) findViewById(R.id.testo_seconda_pagina);
                    t.setText("bravo");

                } else {

                    // permission negata: provvediamo in qualche maniera
                    TextView t = (TextView) findViewById(R.id.testo_seconda_pagina);
                    t.setText("sbagliato");
                }
                return;
            }
        }
    }
}

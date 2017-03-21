package com.example.efricano.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    private TextView testo;
    private EditText editable_text;
    private Toast pieceToast;
    private int year;
    private int month;
    private int day;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button 2 vado a settare l azione nel momento in cui il button viene cliccato
        Button bt1 = (Button) findViewById(R.id.button_toast);
        bt1.setOnClickListener(new SecondaPagina());

        //button 1 vado nella seconda activity
        Button bt2 = (Button) findViewById(R.id.button_seconda_pagina);
        bt2.setOnClickListener(new SecondaPagina());

        Button bt3 = (Button) findViewById(R.id.button_gestione);
        bt3.setOnClickListener(new SecondaPagina());

        Button bt4 = (Button) findViewById(R.id.button_webview);
        bt4.setOnClickListener(new SecondaPagina());

        Button bt5 = (Button) findViewById(R.id.button_ListView);
        bt5.setOnClickListener(new SecondaPagina());

        Button bt6 = (Button) findViewById(R.id.button_GridView);
        bt6.setOnClickListener(new SecondaPagina());

        Button bt7 = (Button) findViewById(R.id.button_Spinner);
        bt7.setOnClickListener(new SecondaPagina());

        Button bt8 = (Button) findViewById(R.id.button_Personal_Adapter);
        bt8.setOnClickListener(new SecondaPagina());

        Button bt9 = (Button) findViewById(R.id.button_Fragment);
        bt9.setOnClickListener(new SecondaPagina());

        Button bt10 = (Button) findViewById(R.id.button_Fragment_versione2);
        bt10.setOnClickListener(new SecondaPagina());

        Button bt11 = (Button) findViewById(R.id.button_Fragment_versione3);
        bt11.setOnClickListener(new SecondaPagina());

        Button bt12 = (Button) findViewById(R.id.button_ScritturaLettura);
        bt12.setOnClickListener(new SecondaPagina());

        testo=(TextView) findViewById(R.id.testo1);
        editable_text=(EditText) findViewById(R.id.editText);

        /*
        bt1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast pieceToast= Toast.makeText(getApplicationContext(), "Image Button One Clicked", Toast.LENGTH_SHORT);
                pieceToast.show();
                TextView t= (TextView)findViewById(R.id.text);
                t.setAllCaps(true);

            }
        });
        */


        //ProgressDialog progress = ProgressDialog.show(this, "Attendere", "Scaricamento in corso...", true);
    }


    class SecondaPagina implements View.OnClickListener {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v){

            Toast pieceToast=null;

            switch (v.getId()){

                case R.id.button_toast:
                    //devo avere il parent,perchè la view su cui chiamo la classe sarebbe il button
                    //vado dal padre e mi trovo poi gli altri text,button ecc

                    //1 APPARE IL TOAST
                    pieceToast=Toast.makeText(v.getContext(),"OK cliccato",Toast.LENGTH_SHORT);
                    pieceToast.show();
                    //2 MODIFICO LA GRANDEZZA DEL TESTO
                    testo.setAllCaps(true);
                    break;

                case R.id.button_seconda_pagina:

                    String testo_ins_string=""+editable_text.getText();
                    Log.d("MyApp",testo_ins_string);

                    Intent i;
                    i = new Intent(v.getContext(),Second_Activity.class);
                    i.putExtra("username", testo_ins_string);
                    Log.d("MyAPP",testo_ins_string);
                    v.getContext().startActivity(i);

                    break;

                case R.id.button_gestione:
                    //devo avere il root,perchè la view su cui chiamo la classe sarebbe il button
                    //vado dal padre e mi trovo poi gli altri text,button ecc
/*
                    Dialog d=new Dialog(v.getContext());
                    d.setTitle("Login");
                    d.setCancelable(true);
                    d.setContentView(R.layout.activity_gestione);
                    d.show();
*/
                    //LISTENER
                    onDateSetListener data_settata=new onDateSetListener();
                    //SCELGO LA DATA CON CUI INIZILIZZARLO
                    DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd ");
                    Calendar cal = Calendar.getInstance();
                    String s="la data di oggi è"+(dateFormat.format(cal));
                    Log.d("MyAPP",s);
                    //datepicker inizializzato alla data di oggi
                    DatePickerDialog p=new DatePickerDialog(v.getContext(),data_settata,
                            cal.get(Calendar.YEAR),
                            cal.get(Calendar.MONTH),
                            cal.get(Calendar.DAY_OF_MONTH));

                    p.show();

                    break;


                case R.id.button_webview:
                    Intent i2;
                    i2 = new Intent(v.getContext(),WebView_Activity.class);
                    v.getContext().startActivity(i2);
                    pieceToast=Toast.makeText(v.getContext(),"OK cliccato 5",Toast.LENGTH_SHORT);
                    pieceToast.show();
                    break;


                case R.id.button_ListView:
                    Intent i3;
                    i3 = new Intent(v.getContext(),ListView_Activity.class);
                    v.getContext().startActivity(i3);
                    break;

                case R.id.button_GridView:
                    Intent i4;
                    i4 = new Intent(v.getContext(),GridView_Activity.class);
                    v.getContext().startActivity(i4);
                    break;

                case R.id.button_Spinner:
                    Intent i5;
                    i5 = new Intent(v.getContext(),Spinner_Activity.class);
                    v.getContext().startActivity(i5);
                    break;

                case R.id.button_Personal_Adapter:
                    Intent i6;
                    i6 = new Intent(v.getContext(),PersonalAdapter_Activity.class);
                    v.getContext().startActivity(i6);
                    break;


                case R.id.button_Fragment:
                    Intent i7;
                    i7 = new Intent(v.getContext(),Fragment_Activity.class);
                    v.getContext().startActivity(i7);
                    break;


                case R.id.button_Fragment_versione2:
                    Intent i8;
                    i8 = new Intent(v.getContext(),Fragment_Activity_2.class);
                    v.getContext().startActivity(i8);
                    break;

                case R.id.button_Fragment_versione3:
                    Intent i9;
                    i9 = new Intent(v.getContext(),Fragment_Activity_3.class);
                    v.getContext().startActivity(i9);
                    break;

                case R.id.button_ScritturaLettura:
                    Intent i10;
                    i10 = new Intent(v.getContext(),ScritturaLettura_Activity.class);
                    v.getContext().startActivity(i10);
                    break;

            }


        }
    }


    }











    class onDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String data=""+dayOfMonth+" "+month+" "+year;
            Log.d("MyAPP",data);
            Intent i;
            i = new Intent(view.getContext(),Third_Activity.class);
            i.putExtra("data", data);

            view.getContext().startActivity(i);
        }
    }






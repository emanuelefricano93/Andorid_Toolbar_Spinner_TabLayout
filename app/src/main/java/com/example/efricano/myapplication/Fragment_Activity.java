package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


/**
 * Created by e.fricano on 08/03/2017.
 */

public class Fragment_Activity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        //qui parte quindi l inserimento normale di un activity che abbiamo dichiarato dal
        //layout che deve contenere solo uno spazio per un fragment
        setContentView(R.layout.activity_fragment);
        if (savedInstanceState == null)
        {
            //qui stiamo dicendo al FragmentManager di iniziare una transazione
            //di aggiungere al contaier(che sarebbe il Fragment layout con l id, che appunto deve andare a
            //contenere una classe HelloFragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container2, new HelloFragment()).commit();

        }

    }



}






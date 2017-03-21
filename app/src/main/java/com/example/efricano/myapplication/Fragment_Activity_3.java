package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by e.fricano on 13/03/2017.
 */

public class Fragment_Activity_3 extends AppCompatActivity implements CountryFragment.OnFragmentEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        Log.d("MyAPP","Inizio Activity fragment 3:"+R.layout.activity_fragment_versione3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_versione3);
        Log.d("MyAPP","Inizio 2 Activity fragment 3");

        if (findViewById(R.id.container) != null)
        {
            // Se è presente il FrameLayout con id container,
            // vuol dire che siamo in SINGLE-PANE perciò
            // è necessario aggiungere il Fragment con la transazione.

            // Se savedInstanceState non è nullo, non siamo alla
            // prima visualizzazione perciò non serve aggiungere il Fragment.

            if (savedInstanceState != null)
                return;

            Log.d("MyAPP","Provo a settare NewCountryFragment Activity fragment 3");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new CountryFragment()).commit();
        }

        Log.d("MyAPP","FINE onCreate Activity fragment 3");
    }
    @Override
    public void selectCountry(String c)
    {
        //ho il fragent delle citta che vado a richiamare
        CityFragment cityFrag = (CityFragment)
                getSupportFragmentManager().findFragmentById(R.id.cityfrag);

        if (cityFrag != null && cityFrag.isInLayout())
        {
            // Il Fragment delle città è già nel layout quindi
            // ne chiediamo solo l'aggiornamento.

            //in questo modo vado a chiamre sull oggetto CityFragment, che sarebbe il frammento con la lista, vediamo
            //andiamo a richiederne l aggiornamento
            cityFrag.onSelectedCountry(c);
        }
        else
        {
            // Siamo in SINGLE-PANE, quindi le FragmentTransaction
            // operano lo switch tra Fragment.

            //se non è proprio presente vediamo che dobbiamo andare a creare un certo fregment, e poi andare a mettere
            //(ricordiamo tutto questo dopo aver selezonato il country, mettiamo questo nel bundle e poi andiamo a settare
            //questo argomento,e qui
            CityFragment frag= new CityFragment();
            Bundle b=new Bundle();
            b.putString("country", c);
            frag.setArguments(b);
            //e qui il punto importante dove vado a far partire la transazione ,e vado a far il replacemnt
            //di questo container, con questo frag
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, frag);
            ft.addToBackStack(null);
            ft.commit();
            //nel momento in cui faccio commit vado a richiamrne la costruizone, e richiamandone la costruzione vado
            //a settare l elenco dei paesi richiesti
        }
    }
}
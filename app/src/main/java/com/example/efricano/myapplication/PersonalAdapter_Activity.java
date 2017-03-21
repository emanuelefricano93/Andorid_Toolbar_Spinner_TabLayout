package com.example.efricano.myapplication;

import android.app.ListActivity;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class PersonalAdapter_Activity extends ListActivity {

    private ArticleAdapter adapter=new ArticleAdapter(this, generateNews());

    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        getListView().setPadding(10, 10, 10, 10);
        setListAdapter(adapter);

       //da notare che qui la listview è come se fosse gia dentro l activiy, che non ha un proprio xml, ma
        //vediamo che vado a settare in questa activity direttament l adapter e siamo a posto, altiremnti
        //come gli esempi precedneti basterebbe andare a settare un adapter in una listView creata a parte ad esempio


    }


    private List<ArticleInfo> generateNews()
    {
        ArrayList<ArticleInfo> list=new ArrayList<ArticleInfo>();
        Calendar c=Calendar.getInstance();

        ArticleInfo tmp=new ArticleInfo();
        tmp.setTitle("WordPress: integrare un pannello opzioni nel tema");
        tmp.setCategory("CMS");
        c.set(2014,3,23);
        tmp.setDate(new Date(c.getTimeInMillis()));
        list.add(tmp);
        tmp=new ArticleInfo();
        tmp.setTitle("WordPress: CIAO seconda notizia");
        tmp.setCategory("CMS");
        c.set(2014,3,23);
        tmp.setDate(new Date(c.getTimeInMillis()));
        list.add(tmp);
        /*
         * OMISSIS: il codice crea altri oggetti "fittizi" da visualizzare
         * */
        return list;
    }


}






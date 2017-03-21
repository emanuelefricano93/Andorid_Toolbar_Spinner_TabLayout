package com.example.efricano.myapplication;


import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.efricano.myapplication.PagerAdapter;

public class Fragment_Activity_2 extends AppCompatActivity
{
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_versione2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Creazione di un NewsReader");


        //QUINDI PER OGNUNA DELLE CATEGORIE AVRò UNA PAGER DOVE ANDARE A MOSTRARE I DATI
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        //E ABBIAMO UN TAB_LAYOUT DOVE ANDARLI A MOSTRARE
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

    }
}

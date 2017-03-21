package com.example.efricano.myapplication;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

/**
 * Created by e.fricano on 13/03/2017.
 */

public class CityFragment extends ListFragment
{
    private ArrayAdapter<String> adapter=null;
    private CountryList l=new CountryList();

    public CityFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        Bundle b=getArguments();
        if (b!=null)
        {
            String c=b.getString("country");
            onSelectedCountry(c);
        }
    }

    public void onSelectedCountry(String country)
    {
        adapter.clear();
        adapter.addAll(l.getCitiesByCountry(country));
    }
}
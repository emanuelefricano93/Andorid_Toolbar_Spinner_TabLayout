package com.example.efricano.myapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class CountryList
{
    private HashMap<String,ArrayList<String>> list;
    public CountryList()
    {
        list=new HashMap<String, ArrayList<String>>();
        ArrayList<String> cities=new ArrayList<String>();
        cities.add("Roma");
        cities.add("Torino");
        cities.add("Firenze");
        list.put("Italia", cities);
        cities=new ArrayList<String>();
        cities.add("Parigi");
        cities.add("Lione");
        cities.add("Marsiglia");
        list.put("Francia", cities);
        cities=new ArrayList<String>();
        cities.add("Madrid");
        cities.add("Barcellona");
        list.put("Spagna", cities);
    }
    public Collection<String> getCountries()
    {
        return list.keySet();
    }
    public Collection<String> getCitiesByCountry(String c)
    {
        return list.get(c);
    }
}

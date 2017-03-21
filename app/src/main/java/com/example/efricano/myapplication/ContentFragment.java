package com.example.efricano.myapplication;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by e.fricano on 09/03/2017.
 */

public class ContentFragment extends ListFragment
{

    @Override
    public void onListItemClick(ListView lv, View view, int position, long id) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle b = getArguments();
        String category = (String) b.get(DataProvider.CATEGORY);

        ArrayAdapter<DataProvider.Content> adapter = new ArrayAdapter<DataProvider.Content>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                DataProvider.getContentsByCategory(category));

        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
package com.example.efricano.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by e.fricano on 08/03/2017.
 */

public class ArticleAdapter extends BaseAdapter {


    private List<ArticleInfo> articles=null;
    private Context context=null;
    private SimpleDateFormat simple=new SimpleDateFormat("dd/MM", Locale.ITALIAN);

    public ArticleAdapter(Context context,List<ArticleInfo> articles)
    {
        this.articles=articles;
        this.context=context;
    }

    @Override
    public int getCount()
    {
        return articles.size();
    }

    @Override
    public Object getItem(int position)
    {
        return articles.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View v, ViewGroup vg)
    {
        if (v==null)
        {
            v=LayoutInflater.from(context).inflate(R.layout.listactivity_row_article, null);
        }
        ArticleInfo ai=(ArticleInfo) getItem(position);
        TextView txt=(TextView) v.findViewById(R.id.txt_article_description);
        txt.setText(ai.getTitle());
        txt=(TextView) v.findViewById(R.id.txt_article_url);
        txt.setText(ai.getCategory());
        txt=(TextView) v.findViewById(R.id.txt_article_datetime);
        txt.setText(simple.format(ai.getDate()));
        return v;
    }

}

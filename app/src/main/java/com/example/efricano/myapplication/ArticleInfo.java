package com.example.efricano.myapplication;

import java.util.Date;

/**
 * Created by e.fricano on 08/03/2017.
 */

class ArticleInfo
{
    private String title;
    private String category;
    private Date date;


    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

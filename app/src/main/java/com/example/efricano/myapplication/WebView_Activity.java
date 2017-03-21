package com.example.efricano.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * Created by e.fricano on 07/03/2017.
 */

public class WebView_Activity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyAPP", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        WebView myWebView = (WebView) findViewById(R.id.webkit);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("https://play.google.com/store/apps");
        myWebView.addJavascriptInterface(new WebAppInterface(), "AndroidObject");

       // wbView.clearView();
       // wbView.measure(100, 100);
       // wbView.getSettings().setUseWideViewPort(true);
        //wbView.getSettings().setLoadWithOverviewMode(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MyAPP", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MyAPP", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MyAPP", "onStop");


    }







}


//Codie e metodi annotadi che verrano visti da javascript

class WebAppInterface
{


    @JavascriptInterface
    public void executeJavaCode()
    {

    }
}

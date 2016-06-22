package com.example.raktim.birdsiitk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                WebView browser = (WebView) findViewById(R.id.webview);
                browser.setWebViewClient(new WebViewClient());
                browser.setVerticalScrollBarEnabled(true);
                WebSettings webSettings = browser.getSettings();
                webSettings.setJavaScriptEnabled(true);
                browser.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                browser.loadUrl("http://www.birds.iitk.ac.in/content/feedback-form");


    }
}


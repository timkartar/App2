package com.example.raktim.birdsiitk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message1);
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

        Button browse = (Button) findViewById(R.id.textView2);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });

        Button gallery = (Button) findViewById(R.id.textView3);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryMessage(view);
            }
        });

        Button topography = (Button) findViewById(R.id.textView5);
        topography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topoMessage(view);
            }
        });

        Button check_list = (Button) findViewById(R.id.textView4);
        check_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMessage(view);
            }
        });

        Button glossary = (Button) findViewById(R.id.textView6);
        glossary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glossaryMessage(view);
            }
        });

        Button biblio = (Button) findViewById(R.id.textView7);
        biblio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biblioMessage(view);
            }
        });

        Button aboutus = (Button) findViewById(R.id.textView9);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutusMessage(view);
            }
        });

        Button feed = (Button) findViewById(R.id.textView8);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedMessage(view);
            }
        });
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this,BrowseActivity.class) ;
        startActivity(intent);
    }

    public void galleryMessage(View view){
        Intent intent = new Intent(this,galleryActivity.class) ;
        startActivity(intent);
    }

    public void topoMessage(View view){
        Intent intent = new Intent(this,TopoActivity.class) ;
        startActivity(intent);
    }

    public void checkMessage(View view){
        Intent intent = new Intent(this,ChecklistActivity.class) ;
        startActivity(intent);
    }

    public void glossaryMessage(View view){
        Intent intent = new Intent(this,GlossaryActivity.class) ;
        startActivity(intent);
    }

    public void biblioMessage(View view){
        Intent intent = new Intent(this,BiblioActivity.class) ;
        startActivity(intent);
    }
    public void aboutusMessage(View view){
        Intent intent = new Intent(this,AboutUsActivity.class) ;
        startActivity(intent);
    }
    public void feedMessage(View view){
        Intent intent = new Intent(this,FeedbackActivity.class) ;
        startActivity(intent);
    }

}


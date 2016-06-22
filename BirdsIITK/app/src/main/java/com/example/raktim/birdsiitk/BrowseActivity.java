package com.example.raktim.birdsiitk;

import android.content.Intent;
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

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
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
        Button  others =(Button) findViewById(R.id.button14);
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                othermessage(v);
            }
        });
        Button  owls =(Button) findViewById(R.id.button7);
        owls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                owlsmessage(v);
            }
        });
        Button  ducks =(Button) findViewById(R.id.button);
        ducks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ducksmessage(v);
            }
        });
        Button  chats =(Button) findViewById(R.id.button1);
        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatsmessage(v);
            }
        });
        Button  snipes =(Button) findViewById(R.id.button8);
        snipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snipesmessage(v);
            }
        });
        Button  eagles =(Button) findViewById(R.id.button5);
        eagles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eaglesmessage(v);
            }
        });
        Button  plovers =(Button) findViewById(R.id.button4);
        plovers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ploversmessage(v);
            }
        });
        Button  ergets =(Button) findViewById(R.id.button3);
        ergets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ergetsmessage(v);
            }
        });
        Button  pippits =(Button) findViewById(R.id.button6);
        pippits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pippitsmessage(v);
            }
        });
        Button  gulls =(Button) findViewById(R.id.button2);
        gulls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gullsmessage(v);
            }
        });
        Button  martins =(Button) findViewById(R.id.button9);
        martins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                martinsmessage(v);
            }
        });
        Button  patrs =(Button) findViewById(R.id.button10);
        patrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patrsmessage(v);
            }
        });
        Button  mynas =(Button) findViewById(R.id.button11);
        mynas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mynasmessage(v);
            }
        });
        Button  cuks =(Button) findViewById(R.id.button12);
        cuks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuksmessage(v);
            }
        });
        Button  doves =(Button) findViewById(R.id.button13);
        doves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dovesmessage(v);
            }
        });
    }
      public void othermessage(View view){
          Intent intent = new Intent(this,OtherActivity.class) ;
          startActivity(intent);
      }
    public void owlsmessage(View view){
        Intent intent = new Intent(this,owlActivity.class) ;
        startActivity(intent);
    }
    public void ducksmessage(View view){
        Intent intent = new Intent(this,ducksActivity.class) ;
        startActivity(intent);
    }
    public void chatsmessage(View view){
        Intent intent = new Intent(this,chatsActivity.class) ;
        startActivity(intent);
    }
    public void snipesmessage(View view){
        Intent intent = new Intent(this,snipesActivity.class) ;
        startActivity(intent);
    }
    public void eaglesmessage(View view){
        Intent intent = new Intent(this,eaglesActivity.class) ;
        startActivity(intent);
    }
    public void ploversmessage(View view){
        Intent intent = new Intent(this,ploversActivity.class) ;
        startActivity(intent);
    }
    public void ergetsmessage(View view){
        Intent intent = new Intent(this,ergetsActivity.class) ;
        startActivity(intent);
    }
    public void pippitsmessage(View view){
        Intent intent = new Intent(this,pippitsActivity.class) ;
        startActivity(intent);
    }
    public void gullsmessage(View view){
        Intent intent = new Intent(this,gullsActivity.class) ;
        startActivity(intent);
    }
    public void martinsmessage(View view){
        Intent intent = new Intent(this,martinsActivity.class) ;
        startActivity(intent);
    }
    public void patrsmessage(View view){
        Intent intent = new Intent(this,patridgesActivity.class) ;
        startActivity(intent);
    }
    public void mynasmessage(View view){
        Intent intent = new Intent(this,mynasActivity.class) ;
        startActivity(intent);
    }
    public void cuksmessage(View view){
        Intent intent = new Intent(this,cuckoos.class) ;
        startActivity(intent);
    }
    public void dovesmessage(View view){
        Intent intent = new Intent(this,dovesActivity.class) ;
        startActivity(intent);
    }
}

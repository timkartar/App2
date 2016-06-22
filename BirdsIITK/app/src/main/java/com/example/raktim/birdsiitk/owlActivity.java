package com.example.raktim.birdsiitk;

import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class owlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owl);
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
        Databasehelper myDbHelper = new Databasehelper(owlActivity.this);
        //myDbHelper.onUpgrade(myDbHelper.myDatabase,1,2);
        try{
            myDbHelper.createDataBase();
        } catch (IOException ice){
            throw new Error ("Unable to create datbase");
        }
        try{
            myDbHelper.openDatabase();
        } catch (SQLException sqle){
            throw sqle;
        }
        final Cursor cursor = myDbHelper.query("owls", null, null, null, null, null, null);
        cursor.moveToFirst();
        change(cursor);
        ((Button) findViewById(R.id.button02)).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (cursor.moveToNext())
                    change(cursor);
                else {
                    cursor.moveToFirst();
                    change(cursor);
                }
            }
        });
        ((Button) findViewById(R.id.button03)).setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                if(cursor.moveToPrevious())
                    change(cursor);
                else{
                    cursor.moveToLast();
                    change(cursor);
                }
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.imageView14);
        registerForContextMenu(imageView);
    }
    private void setCurrentImage(Bitmap theImage) {
        final ImageView imageView = (ImageView) findViewById(R.id.imageView14);
        imageView.setImageBitmap(theImage);}
    public void change(Cursor cursor){
        byte[] imageByteArray=cursor.getBlob(cursor.getColumnIndex("pic"));
        ByteArrayInputStream imageStream = new ByteArrayInputStream(imageByteArray);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        setCurrentImage(theImage);
        TextView name= (TextView) findViewById(R.id.textView15);
        name.setText("NAME: " + cursor.getString(1) + "\n");
        TextView scname= (TextView) findViewById(R.id.textView16);
        scname.setText("SCIENTIFIC NAME: " + cursor.getString(2) + "\n");
        TextView des= (TextView) findViewById(R.id.textView17);
        des.setText(cursor.getString(3) + "\n");
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "set as wallpaper!");
        //menu.add(0, v.getId(), 0, "name");

    }

    @Override
    public boolean onContextItemSelected (MenuItem item){
        if (item.getTitle() == "set as wallpaper!") {
            ImageView imageView = (ImageView) findViewById(R.id.imageView14);

            Bitmap theImage = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            HeavyLifter chuckNorris = new HeavyLifter(this, chuckFinishedHandler);
            chuckNorris.setResourceAsWallpaper(theImage);

        } //else if (item.getTitle() == "name") {
        //ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            /*}*/ else {
            return false;
        }
        return true;
    }

    private  android.os.Handler chuckFinishedHandler = new android.os.Handler() {



        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(owlActivity.this, "Wallpaper set", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(owlActivity.this, "Uh oh, can't do that right now", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

    };

}

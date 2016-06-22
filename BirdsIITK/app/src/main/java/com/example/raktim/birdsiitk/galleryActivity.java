package com.example.raktim.birdsiitk;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;


public class galleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
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
        Databasehelper myDbHelper = new Databasehelper(galleryActivity.this);
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
        String[] title = {"owls","pippits","birds","eagles","ergets","ducks","martins","chats","doves","gulls","mynas","plovers","snipes"};
        int a = new Random().nextInt(title.length);
        final Cursor cursor = myDbHelper.query(title[a], null, null, null, null, null, null);
        cursor.moveToFirst();
        ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        //imageView.setOnLongClickListener(new View.OnLongClickListener() {

          //  @Override
            //public boolean onLongClick(View v) {
                //your stuff
              //  return true;
            //}
        //});
        setInitialImage(cursor);
        setImageRotateListener(cursor);
        registerForContextMenu(imageView);


    }
      public void setImageRotateListener(final Cursor cursor) {
         final Button rotatebutton = (Button) findViewById(R.id.btnRotateImage);
         rotatebutton.setOnClickListener(new View.OnClickListener() {

             public void onClick(View arg0) {
                 if (cursor.move(1))
                     setCurrentImage(cursor);
                 else {
                     cursor.moveToFirst();
                     setCurrentImage(cursor);
                 }//a = cursor.getPosition();
                 }

         });
          final Button rotatebutton2 = (Button) findViewById(R.id.btnRotateImage2);
          rotatebutton2.setOnClickListener(new View.OnClickListener() {

              public void onClick(View arg0) {
                  if (cursor.move(-1))
                      setCurrentImage(cursor);
                  else {
                      cursor.moveToLast();
                      setCurrentImage(cursor);
                  }//a = cursor.getPosition();
              }
          });
    }

    public void setInitialImage(Cursor cursor) {
        setCurrentImage(cursor);
    }


    public void setCurrentImage(Cursor cursor) {
        byte[] imageByteArray=cursor.getBlob(cursor.getColumnIndex("pic"));
        ByteArrayInputStream imageStream = new ByteArrayInputStream(imageByteArray);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        final ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        imageView.setImageBitmap(theImage);
        Toast.makeText(this, "NAME: " + cursor.getString(1) + "\n"+"SCIENTIFIC NAME: " + cursor.getString(2) + "\n", Toast.LENGTH_LONG).show();


    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "set as wallpaper!");
        //menu.add(0, v.getId(), 0, "Description");

    }
    @Override
    public boolean onContextItemSelected (MenuItem item){
            if (item.getTitle() == "set as wallpaper!") {
                ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);

                Bitmap theImage = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                HeavyLifter chuckNorris = new HeavyLifter(this, chuckFinishedHandler);
                chuckNorris.setResourceAsWallpaper(theImage);

            } else if (item.getTitle() == "Description") {
               // show(a);
            } else {
                return false;
            }
            return true;
        }

    private  android.os.Handler chuckFinishedHandler = new android.os.Handler() {



        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(galleryActivity.this, "Wallpaper set", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(galleryActivity.this, "Uh oh, can't do that right now", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

    };
      public void show(int a){
          Databasehelper myDbHelper = new Databasehelper(galleryActivity.this);
          final Cursor c = myDbHelper.query("birds", null, null, null, null, null, null);
          c.moveToPosition(a);
          Toast.makeText(this, "NAME: " + c.getString(1) + "\n"+"SCIENTIFIC NAME: " + c.getString(2) + "\n"+ c.getString(3) + "\n", Toast.LENGTH_LONG).show();

      }
    //public void setnewtable(Cursor cursor,int a) {

      //  }


    }



















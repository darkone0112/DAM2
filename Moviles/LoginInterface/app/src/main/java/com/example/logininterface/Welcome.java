package com.example.logininterface;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.time.Instant;


public class Welcome extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String urlGif = "https://media.tenor.com/KWMg8hfohPsAAAAd/bobross.gif";
        ImageView kebabgif = (ImageView)findViewById(R.id.kebabgif);
        Uri uri = Uri.parse(urlGif);
        Glide.with(getApplicationContext()).load(uri).into(kebabgif);
        System.out.println(uri);
    }
}
package com.example.logininterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView email,password;
    public ImageButton kebabbtn;
    public ImageView bsod;
    public Boolean flag = false;
    public LinearLayout fondo;
    public static String laclave = "laclave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fondo = findViewById(R.id.fondo);
        email = findViewById(R.id.email);
        bsod = findViewById(R.id.bsod);
        password = findViewById(R.id.password);
        kebabbtn = findViewById(R.id.kebabbtn);
        kebabbtn.setOnClickListener(this);

    }
    public File archivo(){
        File drawable = new File(getApplicationContext().getFilesDir().getAbsolutePath()+"/bsod.png");
        return drawable;
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.kebabbtn:
                checkData();
            break;
            default:

            break;
        }
    }
    /*public void visibility(){
        File drawable = archivo();
        System.out.println(drawable.getAbsolutePath());
        if (fondo.getBackground().toString() == "@drawable/donerlogo"){
            fondo.setBackground(Drawable.createFromPath(drawable.getAbsolutePath()));
        }else{
            fondo.setBackground(Drawable.createFromPath(drawable.getAbsolutePath()));
        }
    }*/
    public void checkData(){
        Pattern emailPatter = Pattern.compile("^(.+)@(.+)$");
        Matcher emailMat = emailPatter.matcher(email.getText().toString());
        if(emailMat.matches()){
            Intent lanzar = new Intent(this,Welcome.class);
            lanzar.putExtra(laclave,"hola");
            startActivity(lanzar);
        }else{
            email.setHint("ERROR AL LOGUEARSE");
        }
    }
}
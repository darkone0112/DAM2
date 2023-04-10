package com.example.trainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class display extends AppCompatActivity implements View.OnClickListener {
    TextView displayBox,confirmada;
    Button goBackBtn, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        displayBox = findViewById(R.id.displayBox);
        confirmada = findViewById(R.id.confirmada);
        goBackBtn = findViewById(R.id.goBackBtn);
        confirm = findViewById(R.id.confirm);
        //display viaje = (display) getIntent().getSerializableExtra("laclave");
        //displayBox.setText(viaje.toString());
        Intent i = getIntent();
        displayBox.setText(i.getStringExtra(MainActivity.laclave));
        goBackBtn.setOnClickListener(this);
        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm:
                confirmada.setText("Orden Confirmada!");
                //confirmada.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                confirmada.setTextColor(Color.GREEN);
                break;
            case R.id.goBackBtn:
                Intent goBack = new Intent(this, MainActivity.class);
                startActivity(goBack);
                break;

        }
    }
}
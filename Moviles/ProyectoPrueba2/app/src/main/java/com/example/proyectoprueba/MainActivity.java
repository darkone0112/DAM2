package com.example.proyectoprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView lSalida;
    Button bContador;
    Button bReset;
    Random random = new Random();
    int color;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lSalida = findViewById(R.id.lSalida);
        bContador = findViewById(R.id.bContador);
        bContador.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    i++;
                    color = random.nextInt(429496729 - 0)+0;
                    lSalida.setText(String.valueOf(i));
                    bContador.setBackgroundColor((int)(0xff000*color));
                    }
                }
        );
        bReset = findViewById(R.id.bReset);
        bReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i = 0;
                        bContador.setBackgroundColor(Color.parseColor("#FF3F51B5"));
                        lSalida.setText(String.valueOf(i));

                    }
                }
        );
        }
}

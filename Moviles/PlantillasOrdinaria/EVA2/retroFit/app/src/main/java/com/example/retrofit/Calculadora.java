package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calculadora extends AppCompatActivity {

    TextView label,n1,n2;
    RadioButton mas,resta,multi,div;
    Button EButton;
    RadioGroup radioGroup;
    int num1,num2;
    Call <Resultado> llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        //Asignamos id a las variables
        label = findViewById(R.id.apiLabel);
        mas = findViewById(R.id.ESuma);
        resta = findViewById(R.id.EResta);
        multi = findViewById(R.id.EMulti);
        div = findViewById(R.id.EDivision);
        n1 = findViewById(R.id.En1);
        n2 = findViewById(R.id.En2);
        EButton = findViewById(R.id.EoperacionButton);
        radioGroup = findViewById(R.id.EGroupRadius);

        //Botón GO!
        EButton.setOnClickListener(view -> {
            num1 = Integer.parseInt(String.valueOf(n1.getText()));
            num2 = Integer.parseInt(String.valueOf(n2.getText()));
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.ESuma:
                    sumaApi(num1,num2);
                    break;
                case R.id.EResta:
                    restaApi(num1,num2);
                    break;
                case R.id.EMulti:
                    multiApi(num1,num2);
                    break;
                case R.id.EDivision:
                    if (num2!=0) {
                        n2.getBackground().clearColorFilter();
                        divApi(num1, num2);
                    } else {
                        n2.getBackground().setColorFilter(Color.parseColor("#fe4848"), PorterDuff.Mode.DARKEN);
                        label.setText("No puede dividir entre 0");
                    }
                    break;
            }
        });
    }

    public void sumaApi(int num1, int num2) {
        //Comprobamos si hay una llamada en curso, de haberlo, se cierra
        if (llamada != null) {
            llamada.cancel();
        }
        llamada = MatesAPI.getInstance().suma(num1,num2);
        llamada.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                label.setText(response.body().resultado);
            }
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                label.setText("error en la conexion API");
            }
        });
    };

    public void restaApi(int num1, int num2) {
        //Comprobamos si hay una llamada en curso, de haberlo, se cierra
        if (llamada != null) {
            llamada.cancel();
        }
        llamada = MatesAPI.getInstance().resta(num1,num2);
        llamada.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                label.setText(response.body().resultado);
            }
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                label.setText("error en la conexion API");
            }
        });
    };

    public void multiApi(int num1, int num2) {
        //Comprobamos si hay una llamada en curso, de haberlo, se cierra
        if (llamada != null) {
            llamada.cancel();
        }
        llamada = MatesAPI.getInstance().multi(num1,num2);
        llamada.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                label.setText(response.body().resultado);
            }
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                label.setText("error en la conexion API");
            }
        });
    };

    public void divApi(int num1, int num2) {
        //Comprobamos si hay una llamada en curso, de haberlo, se cierra
        if (llamada != null) {
            llamada.cancel();
        }
        llamada = MatesAPI.getInstance().div(num1,num2);
        llamada.enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                label.setText(response.body().resultado);
            }
            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                label.setText("error en la conexion API");
            }
        });
    };

}
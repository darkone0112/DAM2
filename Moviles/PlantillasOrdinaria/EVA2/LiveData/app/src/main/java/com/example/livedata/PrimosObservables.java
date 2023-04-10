package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PrimosObservables extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    TextView tv1,tv2;
    MutableLiveData<Integer> mld;
    ModelPrimo mp;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos_observables);
        mp=new ModelPrimo();
        et1 = findViewById(R.id.menor);
        et2 = findViewById(R.id.mayor);
        pb= findViewById(R.id.pBarra);
        btn = findViewById(R.id.genera);
        tv1 = findViewById(R.id.tv1);
        tv2= findViewById(R.id.tv2);
        mld = new MutableLiveData<Integer>(0);
        MutableLiveData<ArrayList> mlPrimos = new MutableLiveData<ArrayList>();
        //LAMBDA GOD
        mld.observe(this, datos -> {
            tv1.setText(datos+"");
            pb.setVisibility(View.INVISIBLE);
        });
        mlPrimos.observe(this, datos ->{
            tv2.setText(datos+"");
            pb.setVisibility(View.INVISIBLE);
        });

        //Mas lambda, al presionar click
        btn.setOnClickListener(view -> {
            pb.setVisibility(View.VISIBLE);
            mld.postValue(mp.calcularPrimo(Integer.parseInt(et1.getText()+""),Integer.parseInt(et2.getText()+"")));
            mlPrimos.postValue(mp.devolverPrimos(Integer.parseInt(et1.getText()+""),Integer.parseInt(et2.getText()+"")));
        });




    }
}
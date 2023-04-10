package ORMActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_repaso.R;

import java.util.List;

public class ORMActivity extends AppCompatActivity {

    EditText ENumLote1,ENombre1,EDescripcion1;
    AppDatabase db;
    PortatilDao portatildao;
    Button EAñadir,SConsulta;
    TextView SConsultaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ormactivity2);

        ENumLote1 = findViewById(R.id.ENumLote);
        ENombre1 = findViewById(R.id.ENombre);
        EDescripcion1 = findViewById(R.id.EDescripcion2);
        EAñadir = findViewById(R.id.EAñadir1);
        SConsulta = findViewById(R.id.SConsulta1);
        SConsultaText = findViewById(R.id.MostrarView);

        //Utilizar Base
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "portatiles").allowMainThreadQueries().build();
        portatildao = db.portatilDao();

        //Boton añadir

        SConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Portatiles> portatiles = portatildao.getAll();
                String sData = "";
                for(Portatiles a : portatiles ){

                    sData += a.Enombre + " - "+a.EDescripcion +"\n";
                }
                SConsultaText.setText(sData);

            }
        });

        EAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Portatiles a = new Portatiles();
                a.Enombre = ENombre1.getText().toString();
                a.EDescripcion = EDescripcion1.getText().toString();

                portatildao.insertAll(a);
            }
        });

    }
}
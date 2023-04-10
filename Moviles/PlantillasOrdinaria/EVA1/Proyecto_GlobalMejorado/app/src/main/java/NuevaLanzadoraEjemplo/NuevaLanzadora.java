package NuevaLanzadoraEjemplo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyecto_global.R;

import PracticaViaje.Recibidora;

public class NuevaLanzadora extends AppCompatActivity {

    Button EEnviar,ESalir;
    EditText EEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_lanzadora);

        EEnviar = findViewById(R.id.EEnviar);
        EEdit = findViewById(R.id.EEdit);
        ESalir = findViewById(R.id.ESalir);

        ActivityResultLauncher<Intent> activadorIntent = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }
        );

        EEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NuevaLanzadora.this, NuevaLanzadora2.class);


            }
        });


    }




}
package com.example.loginauthfuncional;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import APIService.AuthRequest;
import APIService.AuthResponse;
import APIService.QuestionClient;
import APIService.QuestionService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {

    private QuestionService apiService;
    private String token;
    Button EButton;
    EditText ENombre,EPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EButton = findViewById(R.id.ELog);
        ENombre = findViewById(R.id.ENombre);
        EPassword = findViewById(R.id.EPassword);

        EButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService = QuestionClient.getClient().create(QuestionService.class);

                AuthRequest authRequest = new AuthRequest(String.valueOf(ENombre.getText()),String.valueOf(EPassword.getText()));
                Call<AuthResponse> call = apiService.authenticate(authRequest);
                call.enqueue(new Callback<AuthResponse>() {
                    @Override
                    public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                        if (response.isSuccessful()) {
                            AuthResponse authResponse = response.body();
                            token = authResponse.getToken();
                            Log.d("On","funcional");
                        } else {
                            Log.d("On","mamaste medio");
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponse> call, Throwable t) {
                        Log.d("On","mamaste full");
                    }
                });
            }
        });



    }
}
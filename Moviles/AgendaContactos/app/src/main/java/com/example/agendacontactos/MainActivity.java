package com.example.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView MyRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyRecycleView = findViewById(R.id.MyRecycleView);
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("pepe","pepe@gmail.com","https://static.cnews.fr/sites/default/files/pepe_the_frog_sad.jpg"));
        contacts.add(new Contact("susi","verysusi@gmail.com","https://files.cults3d.com/uploaders/15629801/illustration-file/b585df30-4634-4ed6-9d0c-769cebc23b95/macizo1.png"));
        ContactAdapter adapter = new ContactAdapter(this);
        adapter.setContact(contacts);
        MyRecycleView.setAdapter(adapter);
        MyRecycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}
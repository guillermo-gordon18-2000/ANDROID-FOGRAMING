package com.example.frograming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
package com.example.frograming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecuperarContrasenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
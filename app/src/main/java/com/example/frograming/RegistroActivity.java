package com.example.frograming;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.frograming.Entidades.Usuarios;
import com.example.frograming.Entidades.Usuarios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombre, apellido, cedula, correo, contrasena1, contrasena2;
    private Spinner facultad, carrera, grupo;
    private boolean validacion, visible;
    private String contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        InicializarControles();
        AttachEvents();
    }

    private void InicializarControles() {
        nombre = (EditText)findViewById(R.id.txtNombre);
        apellido = (EditText)findViewById(R.id.txtApellido);
        cedula = (EditText)findViewById(R.id.txtCedula);
        correo = (EditText)findViewById(R.id.txtCorreo);
        contrasena1 = (EditText)findViewById(R.id.txtContrasena); //decifrar contrasena y comparar
        contrasena2 = (EditText)findViewById(R.id.txtConfirmar);
        facultad = (Spinner) findViewById(R.id.spnFacultad);
        carrera = (Spinner) findViewById(R.id.spnCarrera);
        grupo = (Spinner) findViewById(R.id.spnGrupo);
        carrera.setEnabled(false);
        grupo.setEnabled(false);
    }

    private void AttachEvents() {
        facultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //obtener valor de spinner
                String facu = facultad.getItemAtPosition(position).toString();

                if (facu.equals("Facultad de Ciencias y Tecnología")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.FCyT, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo1, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);
                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else if (facu.equals("Facultad de Ingeniería Civil")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this, R.array.FIC, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo2, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);
                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else if (facu.equals("Facultad de Ingeniería Eléctrica")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this, R.array.FIE, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo3, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);
                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else if (facu.equals("Facultad de Ingeniería Industrial")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this, R.array.FII, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo4, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else if (facu.equals("Facultad de Ingeniería Mecánica")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this, R.array.FIM, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo5, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);
                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else if (facu.equals("Facultad de Ingeniería de Sistemas Computacionales")) {
                    ArrayAdapter adapterCarrera = ArrayAdapter
                            .createFromResource(RegistroActivity.this, R.array.FISC, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    ArrayAdapter adapterGrupo = ArrayAdapter
                            .createFromResource(RegistroActivity.this,R.array.Grupo6, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    carrera.setAdapter(adapterCarrera);
                    grupo.setAdapter(adapterGrupo);
                    carrera.setEnabled(true);
                    grupo.setEnabled(true);
                } else{
                    carrera.setEnabled(false);
                    grupo.setEnabled(false);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public boolean validarContrasena(String pass1, String pass2){
        boolean validacion = false;
        if(pass1 != null && pass2 != null) {
            if (pass1.equals(pass2)) {
                validacion = true;
                contrasena=pass1;
            }
        }
        else{
            validacion = false;
        }
        return validacion;
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void ver(View v){

        try {
            validacion=validarContrasena(contrasena1.getText().toString(), contrasena2.getText().toString());
            String contra;
            contra=md5(contrasena1.getText().toString());
            if (validacion == true) {
                Usuarios usuario = new Usuarios(
                        nombre.getText().toString(),
                        apellido.getText().toString(),
                        cedula.getText().toString(),
                        correo.getText().toString(),
                        contra,
                        facultad.getSelectedItem().toString(),
                        carrera.getSelectedItem().toString(),
                        grupo.getSelectedItem().toString()

                );

                Boolean registrado = usuario.insert(getApplicationContext());
                if (registrado) {
                    Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this,TematicaActivity.class));
                } else {
                    //AlertDialog
                    //Toast.makeText(this, "Error, su cuenta no ha podido ser registrada", Toast.LENGTH_LONG).show();
                }
            }
            else
                Toast.makeText(this, "Error, su cuenta no ha podido ser registrada", Toast.LENGTH_LONG).show();


        }catch(Exception e){
            Toast.makeText(this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void conCuenta(View v){
        startActivity(new Intent(this, InicioSesionActivity.class));
    }
}
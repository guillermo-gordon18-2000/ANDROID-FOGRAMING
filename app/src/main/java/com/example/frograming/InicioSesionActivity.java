package com.example.frograming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.frograming.Modelos.LoginRequest;
import com.example.frograming.Modelos.LoginResponse;
import com.example.frograming.Service.ApiService;
import com.google.android.material.textfield.TextInputLayout;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioSesionActivity extends AppCompatActivity {

    EditText correo, contrasena;
    String user = "a.albaez05@gmail.com", password = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Frograming);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        InicializarControles();
    }

    private void InicializarControles() {
        correo = (EditText)findViewById(R.id.txtCorreo);
        contrasena = (EditText) findViewById(R.id.txtContrasena);
    }


    public void ValidarUsuario(View v) {
        try {
            String contrasenaHash = md5(contrasena.getText().toString());
            LoginRequest request = new LoginRequest();
            request.setCorreo(correo.getText().toString());
            request.setContrasena(contrasenaHash);

            Call<LoginResponse> login = ApiService.getApiService().Loguear(request);
            login.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse loginCorrecto = response.body();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    int x =1;
                }
            });

           /* if (correo.getText().toString().equals(user) && contrasena.getText().toString().equals(password)) {
                Toast.makeText(this,"¡Login exitoso!", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this,"Datos ", Toast.LENGTH_LONG).show(); */

        } catch (Exception e) {
            Toast.makeText(this,"Error de tipo: "+e, Toast.LENGTH_LONG).show();
        }
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

    public void contrasenaOlvidada(View v){
        startActivity(new Intent(this, RecuperarContrasenaActivity.class));
    }

    public void sinCuenta(View v){
        startActivity(new Intent(this, RegistroActivity.class));
    }
}
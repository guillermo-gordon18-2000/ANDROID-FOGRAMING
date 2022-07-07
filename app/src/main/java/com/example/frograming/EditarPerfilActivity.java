package com.example.frograming;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EditarPerfilActivity extends AppCompatActivity {
    //No se ha trabado en las otras clases como Entidades y Helpers

    private String contrasena;
    private boolean validacion;
    ImageView imgFoto;
    private EditText nombre, apellido, cedula, correo, contrasena1, contrasena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //imagen =(LayerDrawable)findDrawableByLayerId(R.id.fot_1);
        imgFoto = findViewById(R.id.imgFoto);
        InicializarControles();
    }

    private void InicializarControles() {
        nombre = (EditText)findViewById(R.id.txtNombre);
        apellido = (EditText)findViewById(R.id.txtApellido);
        correo = (EditText)findViewById(R.id.txtCorreo);
        contrasena1 = (EditText)findViewById(R.id.txtContrasena); //decifrar contrasena y comparar
        contrasena2 = (EditText)findViewById(R.id.txtConfirmar);
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

    public void ver(View v){

        try {
            validacion=validarContrasena(contrasena1.getText().toString(), contrasena2.getText().toString());
            String contra;
            contra=md5(contrasena1.getText().toString());
            if (validacion == true) { /*  //Guardar datos aun se sigue trabjando
                Usuarios usuario = new Usuarios(
                 nombre.getText().toString(),
                 apellido.getText().toString(),
                 correo.getText().toString(),
                 contra
                );
               Boolean registrado = usuario.insert(getApplicationContext());
               if (registrado) {
                   Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this,TematicaActivity.class));
                } else {
                    AlertDialog
                Toast.makeText(this, "Contrase;a correcta", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Error, su cuenta no ha podido ser registrada", Toast.LENGTH_LONG).show();
                }
               */
            }
            else
                Toast.makeText(this, "[Error]  Contaseña incorrecta", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(this, "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarPerfil(View v){//Proximamente

        Toast.makeText(this, " COMMING SON", Toast.LENGTH_LONG).show();
    }

    // Metodos Para ecoger Imagenes desde galerias y recortarlas en circulos

    public void OnClick(View v){
        Toast.makeText(this, " Entrando a Galeria", Toast.LENGTH_LONG).show();
        cargarImagen();
    }    // Cuando se da click para imagenes

    private void cargarImagen() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent, "Seleccione la aplicacion"),10);
        //  Glide.with(getBaseContext()).load(R.drawable.guillermo).apply(RequestOptions.circleCropTransform()).into(imgFoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode!=RESULT_OK){
            Uri path = data.getData();
            Glide.with(getBaseContext()).load(data.getData()).apply(RequestOptions.circleCropTransform()).into(imgFoto);
        }
        // Glide.with(getBaseContext()).load(data.getData()).apply(RequestOptions.circleCropTransform()).into(imgFoto);
    }    // Selecciona la imagen y la infla
}


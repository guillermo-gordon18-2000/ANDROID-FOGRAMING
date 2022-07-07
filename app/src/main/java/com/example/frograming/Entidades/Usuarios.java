package com.example.frograming.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.frograming.Helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private int id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String contrasena;
    private String facultad;
    private String carrera;
    private String grupo;

    public Usuarios() {
    }

    public Usuarios(int id, String nombre, String apellido, String cedula, String correo, String contrasena, String facultad, String carrera, String grupo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
        this.facultad = facultad;
        this.carrera = carrera;
        this.grupo = grupo;
    }

    public Usuarios(String nombre, String apellido, String cedula, String correo, String contrasena, String facultad, String carrera, String grupo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
        this.facultad = facultad;
        this.carrera = carrera;
        this.grupo = grupo;
    }

    public Usuarios(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    //insercion de datos a la bd
    public boolean insert(Context context){
        try{
            //Validacion de que campos en nullo o vacio nombre ,apellido , correo , cedula , contrasena ,facultad ,carrera ,grupo
            DbHelper dbHelper = new DbHelper(context,"usuarios");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db!= null){
                ContentValues content = new ContentValues();
                content.put("nombre",this.getNombre());
                content.put("apellido",this.getApellido());
                content.put("correo",this.getCedula());
                content.put("cedula",this.getCorreo());
                content.put("contrasena",this.getContrasena());
                content.put("facultad",this.getFacultad());
                content.put("carrera",this.getCarrera());
                content.put("grupo",this.getGrupo());

                db.insert("usuarios",null,content);
                return true;
            }
        }catch (Exception e){
            Toast.makeText(context,"Error en insercion de usuario =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return false;
    }

  /*  //obtener nombre para bienvenida
    public List<String> ObtenerDatos(Context context){
        List<String> datosUsuario = new ArrayList<>();
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"vacunados");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!= null){
                String[] campos = new String[]{"nombre","id"};
                Cursor cursor = db.query("usuarios",campos,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        datosUsuario.add(cursor.getInt(1)+"-"+cursor.getString(0));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en select de nombre de usuario =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return datosUsuario;
    }*/
}

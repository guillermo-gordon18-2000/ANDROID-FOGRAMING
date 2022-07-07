package com.example.frograming.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.frograming.R;



public class DbHelper extends SQLiteOpenHelper {

    private String Usuarios = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,apellido TEXT, correo TEXT, cedula TEXT, contrasena TEXT,facultad TEXT,carrera TEXT,grupo TEXT)";

    public DbHelper(Context context, String dbName){
        super(context,
                dbName,
                null,
                R.integer.db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Usuarios);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
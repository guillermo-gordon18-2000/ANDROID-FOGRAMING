package com.example.frograming.Modelos;

public class LoginResponse {
    String nombre;
    int credenciales_id, usuario_id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCredenciales_id() {
        return credenciales_id;
    }

    public void setCredenciales_id(int credenciales_id) {
        this.credenciales_id = credenciales_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}

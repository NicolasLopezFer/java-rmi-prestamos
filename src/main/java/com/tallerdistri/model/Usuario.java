package com.tallerdistri.model;

public class Usuario {
    
    long identificacion;
    String nombreCompleto;
    String email;
    String telefono;

    public Usuario() {}

    public Usuario(long identificacion, String nombreCompleto, String email, String telefono) {
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
    }


    public long getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}

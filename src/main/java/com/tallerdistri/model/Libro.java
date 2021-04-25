package com.tallerdistri.model;

public class Libro {
    long id;
    String isbn;
    String nombre;
    int cantidadTotal;
    int cantidadPrestada;

    

    public Libro(long id, String isbn, String nombre, int cantidadTotal, int cantidadPrestada) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.cantidadTotal = cantidadTotal;
        this.cantidadPrestada = cantidadPrestada;
    }

    
    public Libro() {
        
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidadTotal() {
        return cantidadTotal;
    }
    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    public int getCantidadPrestada() {
        return cantidadPrestada;
    }
    public void setCantidadPrestada(int cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }
    
    
}
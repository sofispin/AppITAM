package com.example.android.ayudaitamita;

public class Evento {
    private long id;
    private String contenido;

    public Evento(long id,String contenido){
        this.id=id;
        this.contenido=contenido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}

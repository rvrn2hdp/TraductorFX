/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analistas.traductorfx.model;

/**
 *
 * @author RVRN2
 */
public class Palabra {

    private int id;
    private String palabra;
    private Idioma idioma;

    public Palabra() {
    }

    public Palabra(int id, String palabra, Idioma idioma) {
        this.id = id;
        this.palabra = palabra;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return palabra;
    }

}

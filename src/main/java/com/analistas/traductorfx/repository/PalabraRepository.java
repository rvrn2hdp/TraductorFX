/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analistas.traductorfx.repository;

import com.analistas.traductorfx.model.Palabra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class PalabraRepository {

    //crear intancias de list
    private List<Palabra> palabrasEsp;
    private List<Palabra> palabrasIng;
    private List<Palabra> palabrasPor;

    //crear una instancia del repositorio de idiomas:
    private IdiomaRepository idiomaRepository = new IdiomaRepository();

    public PalabraRepository() {

        //instanciar las listas
        palabrasEsp = new ArrayList<>();
        palabrasIng = new ArrayList<>();
        palabrasPor = new ArrayList<>();

        //Añadir palabras a las colecciones:
        palabrasEsp.add(new Palabra(1, "Perro", idiomaRepository.getIdiomas().get(0)));
        palabrasEsp.add(new Palabra(2, "Gato", idiomaRepository.getIdiomas().get(0)));
        palabrasEsp.add(new Palabra(3, "Pollo", idiomaRepository.getIdiomas().get(0)));

        palabrasIng.add(new Palabra(1, "Dog", idiomaRepository.getIdiomas().get(1)));
        palabrasIng.add(new Palabra(2, "cat", idiomaRepository.getIdiomas().get(1)));
        palabrasIng.add(new Palabra(3, "Chicken", idiomaRepository.getIdiomas().get(1)));
        
        palabrasPor.add(new Palabra(1, "Cachorro", idiomaRepository.getIdiomas().get(2)));
        palabrasPor.add(new Palabra(2, "Gato", idiomaRepository.getIdiomas().get(2)));
        palabrasPor.add(new Palabra(3, "Frango", idiomaRepository.getIdiomas().get(2)));

    }

    public List<Palabra> getPalabrasEsp() {
        return palabrasEsp;
    }

    public List<Palabra> getPalabrasIng() {
        return palabrasIng;
    }

    public List<Palabra> getPalabrasPor() {
        return palabrasPor;
    }

}

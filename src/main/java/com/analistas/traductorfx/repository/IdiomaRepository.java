package com.analistas.traductorfx.repository;

import com.analistas.traductorfx.model.Idioma;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class IdiomaRepository {

    private List<Idioma> idiomas;
    
    public IdiomaRepository() {
        idiomas = new ArrayList<>();

        idiomas.add(new Idioma(1, "Español"));
        idiomas.add(new Idioma(2, "Inglés"));
        idiomas.add(new Idioma(3, "Português"));
        
        
    }
    
    public List<Idioma> getIdiomas() {
        return idiomas;
    }
    
}

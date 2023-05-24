package com.analistas.traductorfx.repository;

import com.analistas.traductorfx.model.Idioma;
import java.util.List;

/**
 *
 * @author RVRN2
 */
public class IdiomaRepository {

    private List<Idioma> idiomas;
    
    public IdiomaRepository() {
        idiomas.add(new Idioma(1, "Inglés"));
        idiomas.add(new Idioma(2, "Portuguës"));
        idiomas.add(new Idioma(3, "Español"));
        
    }
    
    public List<Idioma> getIdiomas() {
        return idiomas;
    }
    
}

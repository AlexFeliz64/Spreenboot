package com.daw2.aprende.service;

import com.daw2.aprende.model.entity.Persona;
import java.util.List;

public interface PersonasService {
    Persona save(Persona persona);

    List<Persona> findAll();

    Persona findByNif(String nif);
}

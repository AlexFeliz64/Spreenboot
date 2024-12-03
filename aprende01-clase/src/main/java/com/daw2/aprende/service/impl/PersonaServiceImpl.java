package com.daw2.aprende.service.impl;

import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.model.repository.PersonasRepository;
import com.daw2.aprende.service.PersonasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    @Transactional
    public Persona save(Persona persona) {
        return (Persona)this.personasRepository.save(persona);
    }

    public List<Persona> findAll() {
        return this.personasRepository.findAll();
    }

    public Persona findByNif(String nif) {
        return this.personasRepository.findByNif(nif);
    }
}

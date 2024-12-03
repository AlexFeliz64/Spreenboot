package com.daw2.aprende.model.repository;

import com.daw2.aprende.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonasRepository
        extends JpaRepository<Persona, Long> {
    Persona findByNif(String nif);

    List<Persona> findByNombre(String nombre);

    List<Persona> findByApellido1(String apellido1);

    List<Persona> findByApellido2(String apellido2);
}

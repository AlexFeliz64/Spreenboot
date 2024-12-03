package com.daw2.aprende.model.repository;


import com.daw2.aprende.model.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticulosRepository extends JpaRepository<Articulo, Long> {

    Articulo findByReferencia(String referencia);

    List<Articulo> findByNombre(String nombre);


}

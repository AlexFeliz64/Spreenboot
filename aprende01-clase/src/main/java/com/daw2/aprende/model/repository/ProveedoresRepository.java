package com.daw2.aprende.model.repository;


import com.daw2.aprende.model.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedoresRepository extends JpaRepository<Proveedor, Long> {
    Proveedor findByNif(String nif);

    List<Proveedor> findByNombre(String nombre);

    List<Proveedor> findByApellido1(String apellido1);

    List<Proveedor> findByApellido2(String apellido2);
}

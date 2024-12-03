package com.daw2.aprende.service;

import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.model.entity.Proveedor;

import java.util.List;

public interface ProveedoresService {
    Proveedor save(Proveedor proveedor);

    List<Proveedor> findAll();

    Proveedor findByNif(String nif);

    void deleteByNif(String nif);

    Proveedor updateByNif(String nif, Proveedor proveedor);
}

package com.daw2.aprende.service;

import com.daw2.aprende.model.entity.Articulo;
import com.daw2.aprende.model.entity.Proveedor;

import java.util.List;

public interface ArticulosService {
    Articulo save(Articulo articulo);

    List<Articulo> findAll();

    Articulo findByRef(String referencia);

}

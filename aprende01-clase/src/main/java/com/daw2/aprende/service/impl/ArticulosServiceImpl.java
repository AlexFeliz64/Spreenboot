package com.daw2.aprende.service.impl;

import com.daw2.aprende.model.entity.Articulo;
import com.daw2.aprende.model.entity.Proveedor;
import com.daw2.aprende.model.repository.ArticulosRepository;
import com.daw2.aprende.model.repository.ProveedoresRepository;
import com.daw2.aprende.service.ArticulosService;
import com.daw2.aprende.service.ProveedoresService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticulosServiceImpl implements ArticulosService {

    @Autowired
    private ArticulosRepository articulosRepository;

    @Transactional
    public Articulo save(Articulo articulo) {
        return (Articulo) this.articulosRepository.save(articulo);
    }

    public List<Articulo> findAll() {
        return this.articulosRepository.findAll();
    }

    public Articulo findByRef(String referencia) {
        return this.articulosRepository.findByReferencia(referencia);
    }
}

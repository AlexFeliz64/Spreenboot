package com.daw2.viajesclase.service;

import com.daw2.viajesclase.model.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    Cliente findByNif(String nif);

    void deleteByNif(String nif);

    Cliente updateByNif(String nif, Cliente cliente);
}
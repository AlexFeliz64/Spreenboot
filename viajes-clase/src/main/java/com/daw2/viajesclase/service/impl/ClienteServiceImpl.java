package com.daw2.viajesclase.service.impl;

import com.daw2.viajesclase.model.entity.Cliente;
import com.daw2.viajesclase.model.repository.ClienteRepository;
import com.daw2.viajesclase.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clientesRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clientesRepository.findAll();
    }

    public Cliente findByNif(String nif) {
        return clientesRepository.findByNif(nif);
    }

    public void deleteByNif(String nif) {
        Cliente cliente = clientesRepository.findByNif(nif);
        if (cliente != null) {
            clientesRepository.delete(cliente);
        }
    }

    public Cliente updateByNif(String nif, Cliente clienteActualizado) {
        Cliente clienteExistente = clientesRepository.findByNif(nif);
        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido1(clienteActualizado.getApellido1());
            clienteExistente.setApellido2(clienteActualizado.getApellido2());
            return clientesRepository.save(clienteExistente);
        } else {
            return null;
        }
    }
}

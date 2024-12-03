package com.daw2.aprende.service.impl;

import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.model.entity.Proveedor;
import com.daw2.aprende.model.repository.PersonasRepository;
import com.daw2.aprende.model.repository.ProveedoresRepository;
import com.daw2.aprende.service.ProveedoresService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Transactional
    public Proveedor save(Proveedor proveedor) {
        return (Proveedor)this.proveedoresRepository.save(proveedor);
    }

    public List<Proveedor> findAll() {
        return this.proveedoresRepository.findAll();
    }

    public Proveedor findByNif(String nif) {
        return this.proveedoresRepository.findByNif(nif);
    }

    public void deleteByNif(String nif) {
        Proveedor proveedor = this.proveedoresRepository.findByNif(nif);
        if (proveedor != null) {
            this.proveedoresRepository.delete(proveedor);
        }
    }

    public Proveedor updateByNif(String nif, Proveedor proveedorActualizado) {
        Proveedor proveedorExistente = this.proveedoresRepository.findByNif(nif);
        if (proveedorExistente != null) {
            proveedorExistente.setNombre(proveedorActualizado.getNombre());
            proveedorExistente.setApellido1(proveedorActualizado.getApellido1());
            proveedorExistente.setApellido2(proveedorActualizado.getApellido2());
            return this.proveedoresRepository.save(proveedorExistente);
        } else {
            return null;
        }
    }
}

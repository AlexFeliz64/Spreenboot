package com.daw2.viajesclase.service.impl;

import com.daw2.viajesclase.model.entity.Empleado;
import com.daw2.viajesclase.model.repository.EmpleadoRepository;
import com.daw2.viajesclase.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadosRepository;

    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadosRepository.save(empleado);
    }

    public List<Empleado> findAll() {
        return empleadosRepository.findAll();
    }

    public Empleado findByNif(String nif) {
        return empleadosRepository.findByNif(nif);
    }

    public void deleteByNif(String nif) {
        Empleado empleado = empleadosRepository.findByNif(nif);
        if (empleado != null) {
            empleadosRepository.delete(empleado);
        }
    }

    public Empleado updateByNif(String nif, Empleado empleadoActualizado) {
        Empleado empleadoExistente = empleadosRepository.findByNif(nif);
        if (empleadoExistente != null) {
            empleadoExistente.setNombre(empleadoActualizado.getNombre());
            empleadoExistente.setApellido1(empleadoActualizado.getApellido1());
            empleadoExistente.setApellido2(empleadoActualizado.getApellido2());
            return empleadosRepository.save(empleadoExistente);
        } else {
            return null;
        }
    }
}

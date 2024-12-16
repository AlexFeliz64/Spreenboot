package com.daw2.viajesclase.service;

import com.daw2.viajesclase.model.entity.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmpleadoService {
    Empleado save(Empleado empleado);

    List<Empleado> findAll();

    Empleado findByNif(String nif);

    void deleteByNif(String nif);

    Empleado updateByNif(String nif, Empleado empleado);
}
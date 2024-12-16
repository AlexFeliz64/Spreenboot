package com.daw2.viajesclase.model.repository;

import com.daw2.viajesclase.model.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByNif(String nif);

    List<Empleado> findByNombre(String nombre);

    List<Empleado> findByApellido1(String apellido1);

    List<Empleado> findByApellido2(String apellido2);

}

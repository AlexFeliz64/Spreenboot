package com.daw2.viajesclase.model.repository;

import com.daw2.viajesclase.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNif(String nif);

    List<Cliente> findByNombre(String nombre);

    List<Cliente> findByApellido1(String apellido1);

    List<Cliente> findByApellido2(String apellido2);

}

package com.daw2.viajesclase.controller;

import com.daw2.viajesclase.model.dto.EmpleadoDto;
import com.daw2.viajesclase.model.dto.ErrorDto;
import com.daw2.viajesclase.model.entity.Empleado;
import com.daw2.viajesclase.service.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/ver")
    public List<EmpleadoDto> ver() {
        return EmpleadoDto.from(empleadoService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = empleadoDto.to();
            empleadoService.save(empleado);
            return ResponseEntity.status(HttpStatus.OK).body(EmpleadoDto.from(empleado));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Empleado no guardado"));
        }
    }

    @DeleteMapping("/borrar/{nif}")
    public ResponseEntity<?> delete(@PathVariable String nif) {
        try {
            empleadoService.deleteByNif(nif);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }

    @PutMapping("/editar/{nif}")
    public ResponseEntity<?> update(@PathVariable String nif, @RequestBody Empleado empleado) {
        try {
            Empleado empleadoActualizado = empleadoService.updateByNif(nif, empleado);
            return ResponseEntity.status(HttpStatus.OK).body(empleadoActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
        }
    }
}

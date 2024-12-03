package com.daw2.aprende.controller;


import com.daw2.aprende.model.dto.ErrorDto;
import com.daw2.aprende.model.dto.PersonaDto;
import com.daw2.aprende.model.dto.ProveedorDto;
import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.model.entity.Proveedor;
import com.daw2.aprende.service.ProveedoresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/pro")
public class ProveedoresController {


//    @GetMapping("/test01")
//    public String test01() {
//        return "test01";
//    }

    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping("/ver")
    public List<ProveedorDto> ver() {
//        List personas = personasService.findAll();
        return ProveedorDto.from(proveedoresService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ProveedorDto proveedorDto) {
        try {
            Proveedor proveedor = proveedorDto.to();
            proveedoresService.save(proveedor);
            return ResponseEntity.status(HttpStatus.OK).body(ProveedorDto.from(proveedor));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Proveedor no guardado"));

        }
    }

    @DeleteMapping("borrar/{nif}")
    public ResponseEntity<?> delete(@PathVariable String nif) {
        try {
            proveedoresService.deleteByNif(nif);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }
    }

    @PutMapping("editar/{nif}")
    public ResponseEntity<?> update(@PathVariable String nif, @RequestBody Proveedor proveedor) {
        try {
            Proveedor proveedorActualizado = proveedoresService.updateByNif(nif, proveedor);
            return ResponseEntity.status(HttpStatus.OK).body(proveedorActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }
    }
}

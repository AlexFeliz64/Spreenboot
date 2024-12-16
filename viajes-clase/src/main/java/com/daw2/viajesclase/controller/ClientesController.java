package com.daw2.viajesclase.controller;

import com.daw2.viajesclase.model.dto.ClienteDto;
import com.daw2.viajesclase.model.dto.ErrorDto;
import com.daw2.viajesclase.model.entity.Cliente;
import com.daw2.viajesclase.service.ClienteService;
import com.daw2.viajesclase.service.impl.ClienteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/ver")
    public List<ClienteDto> ver() {
        return ClienteDto.from(clienteService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ClienteDto clienteDto) {
        try {
            Cliente cliente = clienteDto.to();
            clienteService.save(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(ClienteDto.from(cliente));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Cliente no guardado"));
        }
    }

    @DeleteMapping("/borrar/{nif}")
    public ResponseEntity<?> delete(@PathVariable String nif) {
        try {
            clienteService.deleteByNif(nif);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @PutMapping("/editar/{nif}")
    public ResponseEntity<?> update(@PathVariable String nif, @RequestBody Cliente cliente) {
        try {
            Cliente clienteActualizado = clienteService.updateByNif(nif, cliente);
            return ResponseEntity.status(HttpStatus.OK).body(clienteActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }
}

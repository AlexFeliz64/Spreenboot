package com.daw2.aprende.controller;


import com.daw2.aprende.model.dto.ArticuloDto;
import com.daw2.aprende.model.dto.ErrorDto;
import com.daw2.aprende.model.dto.ProveedorDto;
import com.daw2.aprende.model.entity.Articulo;
import com.daw2.aprende.model.entity.Proveedor;
import com.daw2.aprende.service.ArticulosService;
import com.daw2.aprende.service.ProveedoresService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/arti")
public class ArticulosController {

    @Autowired
    private ArticulosService articulosService;

    @GetMapping("/ver")
    public List<ArticuloDto> ver() {
//        List personas = personasService.findAll();
        return ArticuloDto.from(articulosService.findAll());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody ArticuloDto articuloDto) {
        try {
            Articulo articulo = articuloDto.to();
            articulosService.save(articulo);
            return ResponseEntity.status(HttpStatus.OK).body(ArticuloDto.from(articulo));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Proveedor no guardado"));

        }
    }

}

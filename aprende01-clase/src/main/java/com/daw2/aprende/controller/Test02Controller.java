package com.daw2.aprende.controller;

import com.daw2.aprende.model.dto.PersonaDto;
import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.service.PersonasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jpa")
public class Test02Controller {

//    @GetMapping("/test01")
//    public String test01() {
//        return "test01";
//    }

    @Autowired
    private PersonasService personasService;
    private com.daw2.aprende.service.PersonasService PersonasService;

    @GetMapping("/test01")
    public Persona text01(String nif, String nombre, String apellido1, String apellido2) {
        Persona persona = new Persona();
        persona.setNif(nif);
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);

        try {
            this.personasService.save(persona);
            return persona;

        } catch (Exception e){
            return null;

        }

    }

    @GetMapping("/test02")
    public List<PersonaDto> test02() {
        List personas = personasService.findAll();
        return personas;
    }

    @GetMapping("/test03")
    public Persona text03(@RequestParam String nif, @RequestParam String nombre,
                          @RequestParam String apellido1, @RequestParam String apellido2,
                          @RequestParam(required = false) Integer edad) {

        log.info("Endpoint: /jpa/test03");
        log.warn("Endpoint: /jpa/test03");
        log.debug("Endpoint: /jpa/test03");
        log.error("Endpoint: /jpa/test03");
        Persona persona = new Persona();
        persona.setNif(nif);
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);

        try {
            this.personasService.save(persona);
            return persona;

        } catch (Exception e){
            return null;

        }

    }
    @GetMapping("/test04")
    public Persona text04(Persona persona) {
        try {
            this.personasService.save(persona);
            return persona;

        } catch (Exception e){
            return null;

        }

    }

    @GetMapping("/test05")
    public Persona text05(@RequestBody Persona persona) {
        try {
            this.personasService.save(persona);
            return persona;

        } catch (Exception e){
            return null;

        }

    }


    @GetMapping("/test07/{nif}")
    public Persona text07(@PathVariable String nif) {
        Persona persona = personasService.findByNif(nif);
        return persona;
    }


}

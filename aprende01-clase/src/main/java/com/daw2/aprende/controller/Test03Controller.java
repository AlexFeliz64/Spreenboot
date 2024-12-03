package com.daw2.aprende.controller;

import com.daw2.aprende.model.dto.PersonaDto;
import com.daw2.aprende.model.dto.ErrorDto;
import com.daw2.aprende.model.dto.PersonaDto0;
import com.daw2.aprende.model.entity.Persona;
import com.daw2.aprende.service.PersonasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin ("*")
@Slf4j
@RestController
@RequestMapping("/code")
public class Test03Controller {

//    @GetMapping("/test01")
//    public String test01() {
//        return "test01";
//    }

    @Autowired
    private PersonasService personasService;
    private com.daw2.aprende.service.PersonasService PersonasService;

    @GetMapping("/test01")
    public ResponseEntity<?> text01(String nif, String nombre, String apellido1, String apellido2) {
        Persona persona = new Persona();
        persona.setNif(nif);
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);

        try {
            this.personasService.save(persona);
            return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));

        } catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Persona no guardada");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        }

    }

    @GetMapping("/test02")
    public List<PersonaDto> test02() {
//        List personas = personasService.findAll();
        return PersonaDto.from(personasService.findAll());
    }

    @GetMapping("/test03")
    public ResponseEntity<?> text03(@RequestParam String nif, @RequestParam String nombre,
                          @RequestParam String apellido1, @RequestParam String apellido2,
                          @RequestParam(required = false) Integer edad) {

        Persona persona = new Persona();
        persona.setNif(nif);
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);

        try {
            this.personasService.save(persona);
            return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Persona no guardada"));
        }

    }
    @GetMapping("/test04")
    public ResponseEntity<?> text04(PersonaDto personadto) {
        try {
            Persona persona = personadto.to();
            personasService.save(persona);
            return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Persona no guardada"));

        }

    }

    @GetMapping("/test05")
    public ResponseEntity<?> text05(@RequestBody PersonaDto personadto) {
        try {
            Persona persona = personadto.to();
            personasService.save(persona);
            return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Persona no guardada"));

        }

    }

    @PostMapping("/test06")
    public ResponseEntity<?> text06(PersonaDto personaDto) {
        try {
            Persona persona = personaDto.to();
            personasService.save(persona);
            return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Persona no guardada"));

        }

    }

    @GetMapping("/test07/{nif}")
    public ResponseEntity<?> text07(@PathVariable String nif) {
        Persona persona = personasService.findByNif(nif);
        if (persona != null) {
        return ResponseEntity.status(HttpStatus.OK).body(PersonaDto.from(persona));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.from("Persona no existe"));
        }
    }


}

package com.daw2.aprende.controller;

import com.daw2.aprende.model.dto.PersonaDto0;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class Test01 {

    @GetMapping("/test01")
    public String test01() {
        return "Mi primer String";
    }

    @GetMapping("/test02")
    public String test02() {
        PersonaDto0 persona =
                new PersonaDto0("Pepito", "Alonso", "Serraner");
        return persona.toString();
    }

    @GetMapping("/test03")
    public List<PersonaDto0> test03() {
        List personas = Arrays.asList(
                new PersonaDto0("Pepito", "Alonso", "Serraner"),
                new PersonaDto0("Pepito", "Alonso", "Serraner"),
                new PersonaDto0("Pepito", "Alonso", "Serraner")
        );
        return personas;
    }
}

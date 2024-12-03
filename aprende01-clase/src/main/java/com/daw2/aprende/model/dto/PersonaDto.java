package com.daw2.aprende.model.dto;

import com.daw2.aprende.model.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonaDto {
    private Long id;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public static PersonaDto from(Persona entity){
        PersonaDto dto = null;
        if(entity != null){
            dto = new PersonaDto();
            dto.setId(entity.getId());
            dto.setNif(entity.getNif());
            dto.setNombre(entity.getNombre());
            dto.setApellido1(entity.getApellido1());
            dto.setApellido2(entity.getApellido2());
        }
        return dto;
    }
    public static List<PersonaDto> from(List<Persona> list){
        List<PersonaDto> dtos = null;
        if(list != null){
            dtos = new ArrayList<PersonaDto>();
            for(Persona entity : list){
                dtos.add(from(entity));
            }
        }
        return dtos;
    }

    public Persona to(){
        Persona persona = new Persona();
        persona.setId(id);
        persona.setNif(nif);
        persona.setNombre(nombre);
        persona.setApellido1(apellido1);
        persona.setApellido2(apellido2);
        return persona;
    }
}

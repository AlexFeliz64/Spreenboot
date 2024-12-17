package com.daw2.viajesclase.model.dto;

import com.daw2.viajesclase.model.entity.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpleadoDto {
    private long id;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;


    public static EmpleadoDto from(Empleado entity)
    {
        EmpleadoDto dto = null;
        if(entity != null)
        {
            dto = new EmpleadoDto();
            dto.setId(entity.getId());
            dto.setNif(entity.getNif());
            dto.setNombre(entity.getNombre());
            dto.setApellido1(entity.getApellido1());
            dto.setApellido2(entity.getApellido2());
        }
        return dto;
    }

    public static List<EmpleadoDto> from(List<Empleado> list) {
        List<EmpleadoDto> dtos = null;
        if (list != null) {
            dtos = new ArrayList<>();
            for (Empleado empleado : list) {
                dtos.add(from(empleado));
            }
        }
        return dtos;
    }

    public Empleado to()
    {
        Empleado entity = new Empleado();
        entity.setId(id);
        entity.setNif(nif);
        entity.setNombre(nombre);
        entity.setApellido1(apellido1);
        entity.setApellido2(apellido2);
        return entity;
    }

}

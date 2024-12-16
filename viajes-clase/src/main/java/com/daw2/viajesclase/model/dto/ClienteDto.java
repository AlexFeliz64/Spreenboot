package com.daw2.viajesclase.model.dto;

import com.daw2.viajesclase.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDto {
    private long id;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;


    public static ClienteDto from(Cliente entity)
    {
        ClienteDto dto = null;
        if(entity != null)
        {
            dto = new ClienteDto();
            dto.setId(entity.getId());
            dto.setNif(entity.getNif());
            dto.setNombre(entity.getNombre());
            dto.setApellido1(entity.getApellido1());
            dto.setApellido2(entity.getApellido2());
        }
        return dto;
    }

    public static List<ClienteDto> from(List<Cliente> list) {
        List<ClienteDto> dtos = null;
        if (list != null) {
            dtos = new ArrayList<>();
            for (Cliente cliente : list) {
                dtos.add(from(cliente));
            }
        }
        return dtos;
    }

    public Cliente to()
    {
        Cliente entity = new Cliente();
        entity.setId(id);
        entity.setNif(nif);
        entity.setNombre(nombre);
        entity.setApellido1(apellido1);
        entity.setApellido2(apellido2);
        return entity;
    }

}

package com.daw2.aprende.model.dto;

import com.daw2.aprende.model.entity.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProveedorDto {
    private Long id;
    private String nif;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public static ProveedorDto from(Proveedor entity){
        ProveedorDto dto = null;
        if(entity != null){
            dto = new ProveedorDto();
            dto.setId(entity.getId());
            dto.setNif(entity.getNif());
            dto.setNombre(entity.getNombre());
            dto.setApellido1(entity.getApellido1());
            dto.setApellido2(entity.getApellido2());
        }
        return dto;
    }
    public static List<ProveedorDto> from(List<Proveedor> list){
        List<ProveedorDto> dtos = null;
        if(list != null){
            dtos = new ArrayList<ProveedorDto>();
            for(Proveedor entity : list){
                dtos.add(from(entity));
            }
        }
        return dtos;
    }

    public Proveedor to(){
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setNif(nif);
        proveedor.setNombre(nombre);
        proveedor.setApellido1(apellido1);
        proveedor.setApellido2(apellido2);
        return proveedor;
    }
}

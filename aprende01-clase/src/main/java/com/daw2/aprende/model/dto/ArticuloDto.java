package com.daw2.aprende.model.dto;

import com.daw2.aprende.model.entity.Articulo;
import com.daw2.aprende.model.entity.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticuloDto {
    private Long id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private Proveedor idProveedor;

    public static ArticuloDto from(Articulo entity){
        ArticuloDto dto = null;
        if(entity != null){
            dto = new ArticuloDto();
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setDescripcion(entity.getDescripcion());
            dto.setIdProveedor(entity.getProveedor());
        }
        return dto;
    }
    public static List<ArticuloDto> from(List<Articulo> list){
        List<ArticuloDto> dtos = null;
        if(list != null){
            dtos = new ArrayList<ArticuloDto>();
            for(Articulo entity : list){
                dtos.add(from(entity));
            }
        }
        return dtos;
    }

    public Articulo to(){
        Articulo articulo = new Articulo();
        articulo.setId(id);
        articulo.setNombre(nombre);
        articulo.setDescripcion(descripcion);
        articulo.setProveedor(idProveedor);
        return articulo;
    }
}

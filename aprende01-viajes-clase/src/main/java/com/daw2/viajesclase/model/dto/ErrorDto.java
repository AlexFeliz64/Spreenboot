package com.daw2.viajesclase.model.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ErrorDto {
    private String message;

    public static ErrorDto from(String message) {
        return new ErrorDto(message);
    }
}

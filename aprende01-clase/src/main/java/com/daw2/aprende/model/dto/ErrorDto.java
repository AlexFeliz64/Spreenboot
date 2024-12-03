package com.daw2.aprende.model.dto;


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
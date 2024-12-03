package com.daw2.aprende.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String referencia;

    @Column(nullable = false, length = 100)
    private String nombre;

    //@Column(columnDefinition = "TEXT")
    @Lob
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="proveedor_id", nullable = true)
    private Proveedor proveedor;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

}

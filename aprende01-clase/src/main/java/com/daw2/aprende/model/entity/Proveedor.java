package com.daw2.aprende.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 12)
    private String nif;

    @Column(nullable = false, length = 15)
    private String nombre;

    @Column(nullable = false, length = 15)
    private String apellido1;

    @Column(length = 15)
    private String apellido2;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    // Relaciones

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Articulo> articulos;
}

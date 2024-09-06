package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="usuarios")
@Data()
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String email;

    @Column()
    private String tipo;

//    @Column()
//    @NotNull()
//    private String phone;

//    @ManyToOne
//    @JoinColumn(name="usuario_id",
//            nullable = false)
//    private Cliente client;
//
//    @ManyToOne
//    @JoinColumn(name="producto_id",
//            nullable = false)
//    private Producto product;
}

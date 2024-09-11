package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="users")
@Data()
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column()
    @NotNull()
    private String rol;

    @Column()
    @NotNull()
    private String name;

    @Column()
    @NotNull()
    @Email()
    private String email;

    @Column()
    @NotNull()
    private String password;
}

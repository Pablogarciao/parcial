package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.CompositeKey;
import jakarta.persistence.*;
import com.example.parcial.UTILS.CompositeKey;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="user")
@Data()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotNull()
    private String roles;

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

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Ticket> tickets;
}

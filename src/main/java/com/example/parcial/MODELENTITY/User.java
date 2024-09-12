package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.UserRoles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Email;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "lastUpdate", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Event> event;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Portfolio> portfolio;

    // Constructor with parameters
    public User (String name, String email, String password, String rol) {
        this.name = name;
        this.rol = rol;
        this.email = email;
        this.password = password;
    }

    // Constructor without parameters
    public User () {}
}

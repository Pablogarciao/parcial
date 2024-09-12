package com.example.parcial.DTO;

import com.example.parcial.UTILS.UserRoles;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class UserDTO {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String rol;

}
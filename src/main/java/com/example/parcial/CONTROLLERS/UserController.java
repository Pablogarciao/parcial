package com.example.parcial.CONTROLLERS;

import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.UserDTO;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
import com.example.parcial.UTILS.UserRoles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getUser() {
        System.out.println("getUser");
        return userService.findAll();
    }

    @PostMapping("/users")
   public ResponseEntity<?> postUser(@Valid @RequestBody UserDTO userDTO) {
    System.out.println("postUser");
    List<String> roles = UserRoles.getAllRoles();

    if (UserRoles.validarRol(roles, userDTO.getRol())) {
        try {
            User user = userService.createUser(userDTO);
            return ResponseEntity.status(201).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    } else {
        return ResponseEntity.status(403).body("INVALID ROLE");
    }
}

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable Long id) {
        System.out.println("deleteUser");
        userService.deleteById(id);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById (@PathVariable Long id) {
        System.out.println("getUserById");

        User e = userService.findById(id);
        Map<String,String> response= new HashMap<>();

        if( e==null ) {
            response.put("message","user not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(e);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> putUser (@RequestBody UserDTO userDTO, @PathVariable Long id) {
        System.out.println("putUser");
        Map<String,String> response= new HashMap<>();
        List<String> roles = UserRoles.getAllRoles();

        if(UserRoles.validarRol(roles, userDTO.getRol())){
            try{
                User e = userService.findById(id);

                if( e==null ) {
                    response.put("message","User not found");
                    return ResponseEntity.status(404).body(response);
                }
                e.setEmail(userDTO.getEmail());
                e.setName(userDTO.getName());
                e.setPassword(userDTO.getPassword());
                e.setRol(userDTO.getRol());
                User UserSaved = userService.save(e);
                return ResponseEntity.status(201).body(UserSaved);
            } catch (Exception error){
                response.put("message",error.getMessage());
                return ResponseEntity.status(500).body(response);
            }
        }else {
            return ResponseEntity.status(403).body("INVALID ROLE");
        }


    }
}

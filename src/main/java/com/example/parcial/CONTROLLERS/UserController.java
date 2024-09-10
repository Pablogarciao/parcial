package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
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
    public ResponseEntity<?> postUser (@Valid @RequestBody User user) {
        System.out.println("postUser");

        Map<String,String> response= new HashMap<>();

        try{
            userService.save(user);
        } catch (Exception e){
            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(user);
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
    public ResponseEntity<?> putUser (@RequestBody User user, @PathVariable Long id) {
        System.out.println("putUser");

        Map<String,String> response= new HashMap<>();

        try{
            User e = userService.findById(id);

            if( e==null ) {
                response.put("message","User not found");
                return ResponseEntity.status(404).body(response);
            }

            User UserSaved = userService.save(user);
            return ResponseEntity.status(201).body(UserSaved);
        } catch (Exception error){
            response.put("message",error.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}

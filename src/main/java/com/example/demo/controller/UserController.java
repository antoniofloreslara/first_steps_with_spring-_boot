package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity <List<UserDTO>> getAllUsers(@RequestParam(required = false) Integer minAge) {
        List<UserDTO> users = userService.getListUsers(minAge);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO==null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity <UserDTO> createUser(@RequestBody User user) {
        URI location = URI.create("/api/users" + user.getId());
        return ResponseEntity.created(location).body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        UserDTO updateUserDTO = userService.updateUser(id,user);
        if (updateUserDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean delete = userService.deleteUser(id);
        if (!delete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
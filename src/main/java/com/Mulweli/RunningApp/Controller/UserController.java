package com.Mulweli.RunningApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mulweli.RunningApp.DataTransferObject.UserRequestDTO;
import com.Mulweli.RunningApp.Entity.User;
import com.Mulweli.RunningApp.Service.UserManagementService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserManagementService userService;

    public UserController(UserManagementService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody UserRequestDTO entity) {
        return userService.update(id,entity.getName(),entity.getEmail(),entity.getPassword(), entity.getPhone());
    }
    
    @DeleteMapping("/{id}")
    public User delete(@PathVariable UUID id){
        return userService.delete(id);
    }
    
}

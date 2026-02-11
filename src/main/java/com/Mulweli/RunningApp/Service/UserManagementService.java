package com.Mulweli.RunningApp.Service;

import java.util.UUID;
import java.util.List;
import org.springframework.stereotype.Service;

import com.Mulweli.RunningApp.Entity.User;
import com.Mulweli.RunningApp.Entity.UserAuthentication;
import com.Mulweli.RunningApp.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserManagementService {
    private final UserRepository userRepo;

    public UserManagementService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Transactional
    public User addUser(String name, String email, String password, String phone){
        UserAuthentication newUserAuth = new UserAuthentication(name+email, password, "USER", true);
        User newUser = new User(name,email,phone);
        newUser.setUserAuthentication(newUserAuth);
        return userRepo.save(newUser);
    }

    @Transactional
    public User addAdmin(String name, String email, String password, String phone){
        UserAuthentication newUserAuth = new UserAuthentication(name+email, password, "ADMIN", true);
        User newUser = new User(name,email,phone);
        newUser.setUserAuthentication(newUserAuth);
        return userRepo.save(newUser);
    }

    @Transactional
    public User delete(UUID id){
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("UserId not found"));
        userRepo.delete(user);
        return user;
    }

    @Transactional
    public User update(UUID id, String name, String email, String password, String phone){
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("UserId not found"));
        UserAuthentication userAuth = user.getUserAuthentication();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        userAuth.setPassword(password);
        userRepo.save(user);
        return user;
    }

    @Transactional
    public User getUser(UUID id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("UserId not found"));
    }

    @Transactional
    public List<User> getUsers(){
        return userRepo.findAll();
    }
}

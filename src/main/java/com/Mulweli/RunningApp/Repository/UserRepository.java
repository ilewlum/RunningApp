package com.Mulweli.RunningApp.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mulweli.RunningApp.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public <Optional> User findByUsername(String Username);
}

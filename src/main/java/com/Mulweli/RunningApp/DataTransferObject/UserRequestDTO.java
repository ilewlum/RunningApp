package com.Mulweli.RunningApp.DataTransferObject;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

public class UserRequestDTO {
    // instance Var
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String password;

    // Constructor
    public UserRequestDTO(){
        this.name = "";
        this.email = "";
        this.phone = "";
        this.username = "";
        this.password = "";
    }

    public UserRequestDTO(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = name+email;
    }

    //getter and setter
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}

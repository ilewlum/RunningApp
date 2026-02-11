package com.Mulweli.RunningApp.Entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    // instance Var (Columns)
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID")
    private UUID id;
    private String name;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "username", nullable = false, unique = true)
    private UserAuthentication userAuth;

    // Constructor
    public User(){
        this.name = "";
        this.email = "";
        this.phone = "";
        this.userAuth = new UserAuthentication();
    }

    public User(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public void setUserAuthentication(UserAuthentication userAuth){
        this.userAuth.copyUserAuthentication(userAuth);
    }

    public UserAuthentication getUserAuthentication(){
        return userAuth;
    }
}

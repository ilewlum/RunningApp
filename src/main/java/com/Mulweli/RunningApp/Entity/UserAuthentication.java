package com.Mulweli.RunningApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User Authentication")
public class UserAuthentication {
    // instance Variables (Columns)
    @Id
    private String username;
    private String password;
    private String role;
    private boolean isEnabled;

    public UserAuthentication(){
        this.username = "";
        this.password = "";
        this.role = "";
        this.isEnabled = false;
    }

    public UserAuthentication(String username, String password, String role, boolean isEnabled){
        this.username = username;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
    }

    public void copyUserAuthentication(UserAuthentication userAuth){
        this.username = userAuth.getUsername();
        this.role = userAuth.getRole();
        this.password = userAuth.getPassword();
        this.isEnabled = userAuth.getIsEnabled();
    }

    // getters and setters
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

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

    public void setIsEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }

    public boolean getIsEnabled(){
        return this.isEnabled;
    }
}

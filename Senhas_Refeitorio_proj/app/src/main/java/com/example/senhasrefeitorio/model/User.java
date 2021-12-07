package com.example.senhasrefeitorio.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey()
    private long codUser;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int typeUser;


    public User(long codUser, String name, String email, String lastName, String password, int typeUser) {
        this.codUser = codUser;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.typeUser = typeUser;
    }

    @Ignore
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public long getCodUser() {
        return codUser;
    }

    public void setCodUser(long codUser) {
        this.codUser = codUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

}

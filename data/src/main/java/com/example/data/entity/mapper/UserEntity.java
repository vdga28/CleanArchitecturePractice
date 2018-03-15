package com.example.data.entity.mapper;

import io.realm.RealmObject;

/**
 * Created by vgarcama on 19/02/2018.
 */

public class UserEntity extends RealmObject {

    private String name;
    private String lastname;
    private String email;
    private String password;

    public UserEntity (){
        //Empty constructor
    }

    public UserEntity(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.rehberapp.model;

public class Kullanici {
    int id;
    String password;
    String username;

    public Kullanici()
    {

    }
    public Kullanici(int id,String password, String username ) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

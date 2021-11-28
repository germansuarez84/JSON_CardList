package com.example.jsonexample;

public class User {
    String id;
    String username;
    String name;
    String email;

    public User(){

    }

    public User(String id, String username, String name, String email)
    {this.id=id;
     this.username=username;
     this.name=name;
     this.email=email;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


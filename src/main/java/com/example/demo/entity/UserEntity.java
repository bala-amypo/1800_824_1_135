package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity 
public class UserEntity
{
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private Timestamp createdAt;

    
    public Long getId()
    {
        return id;
    }

}
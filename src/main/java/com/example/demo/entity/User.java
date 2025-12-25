package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


import java.sql.Timestamp;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;

    //private String role;

    
    @Enumerated(EnumType.STRING)
    private Role role;

    private Timestamp createdAt;

  

     

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public String getFullName() {
         return fullName; 
         }
    public String getEmail() {
         return email;
          }
    public String getPassword() {
         return password;
          }
    public Role getRole() {
         return role;
          }
    public Timestamp getCreatedAt() {
         return createdAt;
          }

    public void setId(Long id) { 
        this.id = id;
         }
    public void setFullName(String fullName) { 
        this.fullName = fullName;
         }
    public void setEmail(String email) { 
        this.email = email;
         }
    public void setPassword(String password) { 
        this.password = password; 
        }
    public void setRole(Role role) { 
        this.role = role; 
        }

     
    public User(Long id, String fullName, String email, String password,Role role,Timestamp createdAt) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }
     public User() {
    }
}

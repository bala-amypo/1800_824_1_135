package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class EventEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private String publisher;
    private Boolean isActive=true;
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
    public String getRole() {
         return role;
          }
    public Boolean getIsActive()
    { 
    return isActive;
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
    public void setRole(String role) { 
        this.role = role; 
        }
    public void setIsActive(Boolean isActive )
    { 
        this.isActive=isActive;
    }

     
    public UserEntity(Long id, String fullName, String email, String password,String role,Timestamp createdAt) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive=isActive;
        this.createdAt = createdAt;
    }
     public UserEntity() {
    }


}
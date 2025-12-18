package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class EventUpdateEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String event;
    private Timestamp subscribedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public String getUser() {
         return user; 
         }
    public String getEvent() {
         return event;
          }
    p 
    
    public Timestamp getSubscribedAt() {
         return subscribedAt;
          }
    

    public void setId(Long id) { 
        this.id = id;
         }
    public void set(String ) { 
        this.title = title;
         }
    public void setDescription(String description) { 
        this.description = description;
         }
    public void setLocation(String location) { 
        this.location = location; 
        }
    public void setCategory(String category) { 
        this.category = category; 
        }
     
     
    public EventUpdateEntity(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher; 
        this.isActive=isActive;
        this.createdAt = createdAt;
    }
     public EventUpdateEntity() {
    }
}
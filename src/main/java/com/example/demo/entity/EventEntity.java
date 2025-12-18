package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class EventEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String event;
    private String updateContent;
    private String updateType;
    private Timestamp postedAt;

    @PrePersist
    public void onCreate() {
        this.postedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public String getEvent() {
         return event; 
         }
    public String getUpdateContext() {
         return updateContent;
          }
    public String getUpdateType() {
         return updateType;
          }
    
    
    public Timestamp getPostedAt() {
         return postedAt;
          }
    

    public void setId(Long id) { 
        this.id = id;
         }
    public void setEvent(String title) { 
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
    public void setPublisher(String publisher) { 
        this.publisher = publisher; 
        }
    public void setIsActive(Boolean isActive )
    { 
        this.isActive=isActive;
    }

     
    public EventEntity(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.publisher = publisher; 
        this.isActive=isActive;
        this.createdAt = createdAt;
    }
     public EventEntity() {
    }
}


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
    public String getTitle() {
         return Title; 
         }
    public String getDescription() {
         return description;
          }
    public String getLocation() {
         return location;
          }
    public String getCategory() {
         return category;
          }
    public String getPublisher() {
         return publisher;
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
    public void setTitle(String title) { 
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

     
    public Event Entity(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.isActive=isActive;
        this.createdAt = createdAt;
    }
     public EventEntity() {
    }
}


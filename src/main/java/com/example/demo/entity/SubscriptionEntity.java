package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class SubscriptionEntity
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
    public void setUser(String user) { 
        this.user = user;
         }
    public void setEvent(String event) { 
        this.event = event;
         }
   
     
     
    public EventUpdateEntity(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }
     public EventUpdateEntity() {
    }
}
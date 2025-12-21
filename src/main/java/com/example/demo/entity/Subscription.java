package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class Subscription
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String event;
    private Timestamp subscribedAt;

    @PrePersist
    public void onCreate() {
        this.subscribedAt = new Timestamp(System.currentTimeMillis());
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
   
     
     
    public Subscription(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }
     public Subscription() {
    }
}
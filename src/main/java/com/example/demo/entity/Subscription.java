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

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
    private Timestamp subscribedAt;

    @PrePersist
    public void onCreate() {
        this.subscribedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public User getUser() {
         return user; 
         }
    public Event getEvent() {
         return event;
          }
    
    
    public Timestamp getSubscribedAt() {
         return subscribedAt;
          }
    

    public void setId(Long id) { 
        this.id = id;
         }
    public void setUser(User user) { 
        this.user = user;
         }
    public void setEvent(Event event) { 
        this.event = event;
         }
   
     
     
    public Subscription(Long id, User user,Event event,Timestamp subscribedAt){

        this.id = id;
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }
     public Subscription() {
    }
}
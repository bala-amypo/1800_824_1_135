package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class BroadcastLogEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String eventUpdate;
    private String subscriber;
    private String deliveryStatus;
    private Timestamp sentAt;

    @PrePersist
    public void onCreate() {
        this.sentAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public String getEventUpdate() {
         return eventUpdate; 
         }
    public String getSubscriber() {
         return subscriber;
          }
    
    
    public Timestamp getSentAt() {
         return sentAt;
          }
    

    public void setId(Long id) { 
        this.id = id;
         }
    public void setEventUpdate(String eventUpdate) { 
        this.eventUpdate = eventUpdate;
         }
    public void setSubscriber(String subscriber) { 
        this.subscriber = subscriber;
         }
   
     
     
    public SubscriptionEntity(Long id, String fullName, String email, String password,String role,Timestamp createdAt,Boolean isActive) {

        this.id = id;
        this.user = user;
        this.event = event;
        this.subscribedAt = subscribedAt;
    }
     public SubscriptionEntity() {
    }
}
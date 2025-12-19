package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class BroadcastLog
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
    public String getDeliveryStatus() {
         return deliveryStatus;
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
     public void setDeliveryStatus(String deliveryStatus) { 
        this.deliveryStatus = deliveryStatus;
         }
   
     
     
    public BroadcastLog(Long id, String eventUpdate, String subscriber,Timestamp sentAt) {

        this.id = id;
        this.eventUpdate =eventUpdate;
        this.subscriber = subscriber;
        this.deliveryStatus = deliveryStatus;
        this.sentAt = sentAt;
         
    }
     public BroadcastLog() {
    }
}
// package com.example.demo.entity;


// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.ManyToOne;

// import java.sql.Timestamp;


// @Entity
// public class BroadcastLog
// {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private EventUpdate eventUpdate;

//     @ManyToOne
//     private User subscriber;
//     private String deliveryStatus;
//     private Timestamp sentAt;

//     @PrePersist
//     public void onCreate() {
//         this.sentAt = new Timestamp(System.currentTimeMillis());
//     }

//     public Long getId() {
//          return id; 
//          }
//     public EventUpdate getEventUpdate() {
//          return eventUpdate; 
//          }
//     public User getSubscriber() {
//          return subscriber;
//           }
//     public String getDeliveryStatus() {
//          return deliveryStatus;
//     }
    
    
//     public Timestamp getSentAt() {
//          return sentAt;
//           }
    

//     public void setId(Long id) { 
//         this.id = id;
//          }
//     public void setEventUpdate(EventUpdate eventUpdate) { 
//         this.eventUpdate = eventUpdate;
//          }
//     public void setSubscriber(User subscriber) { 
//         this.subscriber = subscriber;
//          }
//      public void setDeliveryStatus(String deliveryStatus) { 
//         this.deliveryStatus = deliveryStatus;
//          }
   
     
     
//     public BroadcastLog(Long id, EventUpdate eventUpdate, User subscriber,Timestamp sentAt) {

//         this.id = id;
//         this.eventUpdate =eventUpdate;
//         this.subscriber = subscriber;
//         this.deliveryStatus = deliveryStatus;
//         this.sentAt = sentAt;
         
//     }
//      public BroadcastLog() {
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class BroadcastLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY logs → ONE event update
    @ManyToOne
    @JoinColumn(name = "event_update_id")
    private EventUpdate eventUpdate;

    // MANY logs → ONE subscriber
    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private User subscriber;

    // // PENDING / SENT / FAILED
    //private String deliveryStatus;


    private Timestamp sentAt;

    public BroadcastLog() {
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public EventUpdate getEventUpdate() {
        return eventUpdate;
    }

    public void setEventUpdate(EventUpdate eventUpdate) {
        this.eventUpdate = eventUpdate;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }
}

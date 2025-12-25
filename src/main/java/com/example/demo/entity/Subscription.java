// package com.example.demo.entity;



// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;


// import java.sql.Timestamp;


// @Entity
// public class Subscription
// {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     @ManyToOne
//     private Event event;
//     private Timestamp subscribedAt;

//     @PrePersist
//     public void onCreate() {
//         this.subscribedAt = new Timestamp(System.currentTimeMillis());
//     }

//     public Long getId() {
//          return id; 
//          }
//     public User getUser() {
//          return user; 
//          }
//     public Event getEvent() {
//          return event;
//           }
    
    
//     public Timestamp getSubscribedAt() {
//          return subscribedAt;
//           }
    

//     public void setId(Long id) { 
//         this.id = id;
//          }
//     public void setUser(User user) { 
//         this.user = user;
//          }
//     public void setEvent(Event event) { 
//         this.event = event;
//          }
   
     
     
//     public Subscription(Long id, User user,Event event,Timestamp subscribedAt){

//         this.id = id;
//         this.user = user;
//         this.event = event;
//         this.subscribedAt = subscribedAt;
//     }
//      public Subscription() {
//     }
// }
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Subscription {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long userId;
//     private Long eventId;

//     // ===== GETTERS / SETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public Long getEventId() {
//         return eventId;
//     }

//     public void setEventId(Long eventId) {
//         this.eventId = eventId;
//     }
// }

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class Subscription {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "event_id")
//     private Event event;

//     public Subscription() {
//     }

//     public Long getId() {
//         return id;
//     }

//     public User getUser() {
//         return user;
//     }

//     // ✅ REQUIRED BY SERVICE + TEST
//     public void setUser(User user) {
//         this.user = user;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     // ✅ REQUIRED BY SERVICE + TEST
//     public void setEvent(Event event) {
//         this.event = event;
//     }
// }
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class Subscription {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     @ManyToOne
//     private Event event;

//     // ===== REQUIRED BY TESTS =====

//     public Long getId() {
//         return id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {     // 🔴 REQUIRED
//         this.user = user;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {  // 🔴 REQUIRED
//         this.event = event;
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}

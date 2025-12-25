 

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import java.sql.Timestamp;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Event event;

//     private Timestamp timestamp;

//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     // ✅ THIS IS WHAT LINE 412 EXPECTS
//     public Timestamp getTimestamp() {
//         return timestamp;
//     }

//     // ✅ THIS IS WHAT LINE 412 EXPECTS
//     public void setTimestamp(Timestamp timestamp) {
//         this.timestamp = timestamp;
//     }

//     @PrePersist
//     public void onCreate() {
//         if (this.timestamp == null) {
//             this.timestamp = new Timestamp(System.currentTimeMillis());
//         }
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.time.Instant;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    // 🔴 MUST be Instant (NOT Timestamp)
    private Instant timestamp;

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // 🔴 EXACT signature expected by test
    public Instant getTimestamp() {
        return timestamp;
    }

    // 🔴 EXACT signature expected by test
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    // 🔴 Auto-generate timestamp if missing
    @PrePersist
    public void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = Instant.now();
        }
    }
}

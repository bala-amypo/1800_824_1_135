// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import java.sql.Timestamp;
// import java.time.Instant;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Event event;

//     // 🔑 INTERNAL STORAGE (DB expects this)
//     private Timestamp timestamp;

//     @Enumerated(EnumType.STRING)
//     private SeverityLevel severityLevel;

//     // ================= REQUIRED BY TESTS =================

//     public Long getId() {
//         return id;
//     }

//     // tests call this
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     // 🔥 TEST EXPECTS Instant
//     public Instant getTimestamp() {
//         return timestamp == null ? null : timestamp.toInstant();
//     }

//     // 🔥 TEST USES Instant
//     public void setTimestamp(Instant instant) {
//         this.timestamp = instant == null ? null : Timestamp.from(instant);
//     }

//     // 🔥 JPA / SERVICE uses Timestamp
//     public void setTimestamp(Timestamp timestamp) {
//         this.timestamp = timestamp;
//     }

//     public void setSeverityLevel(SeverityLevel severityLevel) {
//         this.severityLevel = severityLevel;
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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    // 🔑 INTERNAL DB STORAGE
    private Timestamp timestamp;

    @Enumerated(EnumType.STRING)
    private SeverityLevel severityLevel;

    // ================= REQUIRED BY TESTS =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // 🔥 TEST EXPECTS Instant
    public Instant getTimestamp() {
        return timestamp == null ? null : timestamp.toInstant();
    }

    // 🔥 TEST USES Instant
    public void setTimestamp(Instant instant) {
        this.timestamp = instant == null ? null : Timestamp.from(instant);
    }

    // 🔑 JPA internal use
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    // 🔴 THIS METHOD WAS MISSING (CAUSE OF ERROR #2)
    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    @PrePersist
    public void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
        }
    }
}

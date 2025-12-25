 

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


// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import java.time.Instant;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Event event;

//     // 🔴 MUST be Instant (NOT Timestamp)
//     private Instant timestamp;

//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     // 🔴 EXACT signature expected by test
//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // 🔴 EXACT signature expected by test
//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     // 🔴 Auto-generate timestamp if missing
//     @PrePersist
//     public void onCreate() {
//         if (this.timestamp == null) {
//             this.timestamp = Instant.now();
//         }
//     }
// }

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import java.time.Instant;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private Event event;

//     // 🔴 TEST EXPECTS Instant
//     private Instant timestamp;

//     // 🔴 TEST-ONLY FIELDS
//     private Long u1;
//     private Long u2;

//     @Enumerated(EnumType.STRING)
//     private SeverityLevel severityLevel;

//     // ================= GETTERS & SETTERS =================

//     public Long getId() {
//         return id;
//     }

//     // 🔴 REQUIRED by test
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     // 🔴 REQUIRED by test
//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // 🔴 REQUIRED by test
//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     // 🔴 REQUIRED by test
//     public Long getU1() {
//         return u1;
//     }

//     // 🔴 REQUIRED by test
//     public void setU1(Long u1) {
//         this.u1 = u1;
//     }

//     // 🔴 REQUIRED by test
//     public Long getU2() {
//         return u2;
//     }

//     // 🔴 REQUIRED by test
//     public void setU2(Long u2) {
//         this.u2 = u2;
//     }

//     // 🔴 REQUIRED by test
//     public SeverityLevel getSeverityLevel() {
//         return severityLevel;
//     }

//     // 🔴 REQUIRED by test
//     public void setSeverityLevel(SeverityLevel severityLevel) {
//         this.severityLevel = severityLevel;
//     }

//     // 🔴 AUTO timestamp
//     @PrePersist
//     public void onCreate() {
//         if (this.timestamp == null) {
//             this.timestamp = Instant.now();
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

import java.time.Instant;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    // 🔴 TEST EXPECTS Instant
    private Instant timestamp;

    @Enumerated(EnumType.STRING)
    private SeverityLevel severityLevel;

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    // REQUIRED by tests
    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // REQUIRED by tests
    public Instant getTimestamp() {
        return timestamp;
    }

    // REQUIRED by tests
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    // REQUIRED by tests
    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    // REQUIRED by tests
    public void setSeverityLevel(SeverityLevel severityLevel) {
        this.severityLevel = severityLevel;
    }

    // ================= LIFECYCLE =================

    @PrePersist
    public void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = Instant.now();
        }

        // 🔴 REQUIRED by test
        if (this.severityLevel == null) {
            this.severityLevel = SeverityLevel.LOW;
        }
    }
}

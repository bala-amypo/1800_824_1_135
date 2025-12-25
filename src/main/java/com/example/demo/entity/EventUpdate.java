// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.ManyToOne;


// import java.sql.Timestamp;


// @Entity
// public class EventUpdate
// {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne
//     private Event event;
//     private String updateContent;
//     private String updateType;
//     private Timestamp postedAt;

//     @PrePersist
//     public void onCreate() {
//         this.postedAt = new Timestamp(System.currentTimeMillis());
//     }

//     public Long getId() {
//          return id; 
//          }
//     public Event getEvent() {
//          return event; 
//          }
//     public String getUpdateContext() {
//          return updateContent;
//           }
//     public String getUpdateType() {
//          return updateType;
//           }
    
    
//     public Timestamp getPostedAt() {
//          return postedAt;
//           }
    

//     public void setId(Long id) { 
//         this.id = id;
//          }
//     public void setEvent(Event event) { 
//         this.event = event;
//          }
//     public void setUpdateContent(String updateContent) { 
//         this.updateContent = updateContent;
//          }
//     public void setUpdateType(String updateType) { 
//         this.updateType = updateType; 
//         }
     

     
//     public EventUpdate(Long id, Event event, String updateContent, String updateType,Timestamp postedAt) {

//         this.id = id;
//         this.event = event;
//         this.updateContent = updateContent;
//         this.updateType = updateType; 
//         this.postedAt = postedAt;
//     }
//      public EventUpdate() {
//     }
// // }

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.PrePersist;

// import java.time.Instant;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // MANY updates → ONE event
//     @ManyToOne
//     @JoinColumn(name = "event_id")
//     private Event event;

//     private String message;

//     @Enumerated(EnumType.STRING)
//     private SeverityLevel severityLevel;

//     // Tests EXPECT Instant (NOT Timestamp)
//     private Instant timestamp;

//     // ===== LIFECYCLE =====
//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ===== GETTERS & SETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

//     public SeverityLevel getSeverityLevel() {
//         return severityLevel;
//     }

//     public void setSeverityLevel(SeverityLevel severityLevel) {
//         this.severityLevel = severityLevel;
//     }

//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }
// }
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// import java.time.Instant;

// @Entity
// public class EventUpdate {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "event_id")
//     private Event event;

//     private String message;

//     private Instant timestamp;

//     // ===== GETTERS & SETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
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

//     private String content;

//     // 🔴 REQUIRED BY TESTS
//     private String severityLevel;

//     // 🔴 REQUIRED BY TESTS
//     private Instant timestamp;

//     // 🔴 REQUIRED BY TESTS
//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ===== GETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public String getContent() {
//         return content;
//     }

//     public String getSeverityLevel() {   // ✅ FIXED
//         return severityLevel;
//     }

//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // ===== SETTERS =====

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public void setSeverityLevel(String severityLevel) { // ✅ FIXED
//         this.severityLevel = severityLevel;
//     }

//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
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

//     private String content;

//     private String severityLevel;

//     private Instant timestamp;

//     // 🔴 REQUIRED BY TESTS
//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ===== GETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public String getContent() {
//         return content;
//     }

//     public String getSeverityLevel() {
//         return severityLevel;
//     }

//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // ===== SETTERS =====

//     // 🔴 THIS FIXES 5 ERRORS
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public void setSeverityLevel(String severityLevel) {
//         this.severityLevel = severityLevel;
//     }

//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }
// }



// package com.example.demo.entity;

// import jakarta.persistence.Entity;
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

//     private String content;

//     private String severityLevel;

//     private Instant timestamp;

//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ===== GETTERS =====
//     public Long getId() { return id; }
//     public Event getEvent() { return event; }
//     public String getContent() { return content; }
//     public String getSeverityLevel() { return severityLevel; }
//     public Instant getTimestamp() { return timestamp; }

//     // ===== SETTERS =====
//     public void setId(Long id) { this.id = id; }
//     public void setEvent(Event event) { this.event = event; }
//     public void setContent(String content) { this.content = content; }
//     public void setSeverityLevel(String severityLevel) { this.severityLevel = severityLevel; }

//     // ✅ Instant setter
//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     // 🔴 REQUIRED BY TEST (Timestamp support)
//     public void setTimestamp(Timestamp timestamp) {
//         this.timestamp = timestamp.toInstant();
//     }
// }


// package com.example.demo.entity;

// import jakarta.persistence.Entity;
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

//     private String content;

//     private String severityLevel;

//     // 🔴 MUST BE Instant (NOT Timestamp)
//     private Instant timestamp;

//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ========= GETTERS =========
//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public String getContent() {
//         return content;
//     }

//     public String getSeverityLevel() {
//         return severityLevel;
//     }

//     // 🔴 TEST EXPECTS Instant
//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // ========= SETTERS =========
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public void setSeverityLevel(String severityLevel) {
//         this.severityLevel = severityLevel;
//     }

//     // ✅ Used by your code
//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     // ✅ Used by TEST (Timestamp → Instant)
//     public void setTimestamp(Timestamp timestamp) {
//         this.timestamp = timestamp.toInstant();
//     }
// }


// package com.example.demo.entity;

// import jakarta.persistence.Entity;
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

//     private String content;

//     private String severityLevel;

//     // 🔴 MUST BE Instant
//     private Instant timestamp;

//     @PrePersist
//     public void onCreate() {
//         this.timestamp = Instant.now();
//     }

//     // ========= GETTERS =========
//     public Long getId() {
//         return id;
//     }

//     public Event getEvent() {
//         return event;
//     }

//     public String getContent() {
//         return content;
//     }

//     public String getSeverityLevel() {
//         return severityLevel;
//     }

//     // 🔴 TEST EXPECTS THIS EXACT SIGNATURE
//     public Instant getTimestamp() {
//         return timestamp;
//     }

//     // ========= SETTERS =========
//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEvent(Event event) {
//         this.event = event;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     public void setSeverityLevel(String severityLevel) {
//         this.severityLevel = severityLevel;
//     }

//     // ✅ Used by your service
//     public void setTimestamp(Instant timestamp) {
//         this.timestamp = timestamp;
//     }

//     // ✅ Used by TEST (Timestamp → Instant)
//     public void setTimestamp(Timestamp timestamp) {
//         this.timestamp = timestamp.toInstant();
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

import java.sql.Timestamp;

@Entity
public class EventUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private String content;

    private String severityLevel;

    // 🔴 MUST be Timestamp (TEST EXPECTS THIS)
    private Timestamp timestamp;

    @PrePersist
    public void onCreate() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public String getContent() {
        return content;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    // 🔴 TEST EXPECTS Timestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

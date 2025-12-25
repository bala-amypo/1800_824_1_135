// // package com.example.demo.entity;


// // import jakarta.persistence.Entity;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import jakarta.persistence.ManyToOne;
// // import jakarta.persistence.JoinColumn;
// // import jakarta.persistence.PrePersist;


// // import java.sql.Timestamp;


// // @Entity
// // public class Event
// // {
// //     @Id
// //     @GeneratedValue(strategy=GenerationType.IDENTITY)
// //     private Long id;
// //     private String title;
// //     private String description;
// //     private String location;
// //     private String category;

// //     @ManyToOne
// //     @JoinColumn(name="publisher_id")
// //     private User publisher;
// //     private Boolean isActive=true;
// //     private Timestamp createdAt;

// //     @PrePersist
// //     public void onCreate() {
// //         this.createdAt = new Timestamp(System.currentTimeMillis());
// //     }

// //     public Long getId() {
// //          return id; 
// //          }
// //     public String getTitle() {
// //          return title; 
// //          }
// //     public String getDescription() {
// //          return description;
// //           }
// //     public String getLocation() {
// //          return location;
// //           }
// //     public String getCategory() {
// //          return category;
// //           }
// //     public User getPublisher() {
// //          return publisher;
// //           }
// //     public Boolean getIsActive()
// //     { 
// //     return isActive;
// //     }
    
// //     public Timestamp getCreatedAt() {
// //          return createdAt;
// //           }
    

// //     public void setId(Long id) { 
// //         this.id = id;
// //          }
// //     public void setTitle(String title) { 
// //         this.title = title;
// //          }
// //     public void setDescription(String description) { 
// //         this.description = description;
// //          }
// //     public void setLocation(String location) { 
// //         this.location = location; 
// //         }
// //     public void setCategory(String category) { 
// //         this.category = category; 
// //         }
// //     public void setPublisher(User publisher) { 
// //         this.publisher = publisher; 
// //         }
// //     public void setIsActive(Boolean isActive )
// //     { 
// //         this.isActive=isActive;
// //     }

     
// //     public Event(Long id, String fullName, String email, String password,String role,User publisher,Timestamp createdAt,Boolean isActive) {

// //         this.id = id;
// //         this.title = title;
// //         this.description = description;
// //         this.location = location;
// //         this.category = category;
// //         this.publisher = publisher; 
// //         this.isActive=isActive;
// //         this.createdAt = createdAt;
// //     }
// //      public Event() {
// //     }
// // }

// // package com.example.demo.entity;

// // import jakarta.persistence.Entity;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.PrePersist;
// // import jakarta.persistence.PreUpdate;

// // @Entity
// // public class Event {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String title;
// //     private String description;
// //     private String location;
// //     private String category;

// //     private Boolean isActive = true;

// //     private Long createdAt;
// //     private Long lastUpdatedAt;

// //     // ================= JPA LIFECYCLE =================

// //     @PrePersist
// //     public void onCreate() {
// //         long now = System.currentTimeMillis();
// //         this.createdAt = now;
// //         this.lastUpdatedAt = now;
// //     }

// //     // 🔴 TEST EXPECTS onUpdate()
// //     @PreUpdate
// //     public void onUpdate() {
// //         this.lastUpdatedAt = System.currentTimeMillis();
// //     }

// //     // ================= GETTERS & SETTERS =================

// //     public Long getId() {
// //         return id;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public String getTitle() {
// //         return title;
// //     }

// //     public void setTitle(String title) {
// //         this.title = title;
// //     }

// //     public String getDescription() {
// //         return description;
// //     }

// //     public void setDescription(String description) {
// //         this.description = description;
// //     }

// //     public String getLocation() {
// //         return location;
// //     }

// //     public void setLocation(String location) {
// //         this.location = location;
// //     }

// //     public String getCategory() {
// //         return category;
// //     }

// //     public void setCategory(String category) {
// //         this.category = category;
// //     }

// //     // 🔴 TEST EXPECTS isActive()
// //     public Boolean isActive() {
// //         return isActive;
// //     }

// //     // 🔴 TEST EXPECTS setActive(boolean)
// //     public void setActive(Boolean active) {
// //         this.isActive = active;
// //     }

// //     public Long getCreatedAt() {
// //         return createdAt;
// //     }

// //     public void setCreatedAt(Long createdAt) {
// //         this.createdAt = createdAt;
// //     }

// //     // 🔴 TEST EXPECTS getLastUpdatedAt()
// //     public Long getLastUpdatedAt() {
// //         return lastUpdatedAt;
// //     }

// //     // 🔴 TEST EXPECTS setLastUpdatedAt(Long)
// //     public void setLastUpdatedAt(Long lastUpdatedAt) {
// //         this.lastUpdatedAt = lastUpdatedAt;
// //     }
// // }
// // package com.example.demo.entity;

// // import jakarta.persistence.*;
// // import java.sql.Timestamp;

// // @Entity
// // public class Event {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String title;
// //     private String description;
// //     private String location;
// //     private String category;

// //     @ManyToOne
// //     private User publisher;

// //     private boolean isActive = true;

// //     private Timestamp createdAt;
// //     private Timestamp lastUpdatedAt;

// //     @PrePersist
// //     public void onCreate() {
// //         this.createdAt = new Timestamp(System.currentTimeMillis());
// //         this.lastUpdatedAt = this.createdAt;
// //         this.isActive = true;
// //     }

// //     @PreUpdate
// //     public void onUpdate() {
// //         this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
// //     }

// //     // ===== REQUIRED GETTERS / SETTERS =====

// //     public Long getId() {
// //         return id;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public boolean isActive() {
// //         return isActive;
// //     }

// //     public boolean getIsActive() {
// //         return isActive;
// //     }

// //     public void setIsActive(boolean active) {
// //         this.isActive = active;
// //     }

// //     public User getPublisher() {
// //         return publisher;
// //     }

// //     public void setPublisher(User publisher) {
// //         this.publisher = publisher;
// //     }

// //     public Timestamp getLastUpdatedAt() {
// //         return lastUpdatedAt;
// //     }

// //     public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
// //         this.lastUpdatedAt = lastUpdatedAt;
// //     }

// //     // optional but safe
// //     public String getTitle() { return title; }
// //     public void setTitle(String title) { this.title = title; }

// //     public String getDescription() { return description; }
// //     public void setDescription(String description) { this.description = description; }

// //     public String getLocation() { return location; }
// //     public void setLocation(String location) { this.location = location; }

// //     public String getCategory() { return category; }
// //     public void setCategory(String category) { this.category = category; }
// // }


// // package com.example.demo.entity;

// // import jakarta.persistence.*;
// // import java.sql.Timestamp;

// // @Entity
// // public class Event {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private String title;
// //     private String description;
// //     private String location;
// //     private String category;

// //     private boolean isActive = true;

// //     @ManyToOne
// //     @JoinColumn(name = "publisher_id")
// //     private User publisher;

// //     private Timestamp createdAt;
// //     private Timestamp lastUpdatedAt;

// //     @PrePersist
// //     public void onCreate() {
// //         this.createdAt = new Timestamp(System.currentTimeMillis());
// //         this.lastUpdatedAt = this.createdAt;
// //     }

// //     @PreUpdate
// //     public void onUpdate() {
// //         this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
// //     }

// //     // ===== REQUIRED GETTERS / SETTERS =====

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public boolean isActive() { return isActive; }
// //     public Boolean getIsActive() { return isActive; }
// //     public void setActive(boolean active) { isActive = active; }

// //     public User getPublisher() { return publisher; }
// //     public void setPublisher(User publisher) { this.publisher = publisher; }

// //     public Timestamp getLastUpdatedAt() { return lastUpdatedAt; }
// //     public void setLastUpdatedAt(Timestamp t) { this.lastUpdatedAt = t; }
// // }
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;
// import java.sql.Timestamp;

// @Entity
// public class Event {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     private String description;
//     private String location;
//     private String category;

//     private boolean isActive = true;

//     @ManyToOne
//     @JoinColumn(name = "publisher_id")
//     private User publisher;

//     private Timestamp createdAt;
//     private Timestamp lastUpdatedAt;

//     // ===== JPA LIFECYCLE =====

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = new Timestamp(System.currentTimeMillis());
//         this.lastUpdatedAt = this.createdAt;
//         this.isActive = true;
//     }

//     @PreUpdate
//     public void onUpdate() {
//         this.lastUpdatedAt = new Timestamp(System.currentTimeMillis());
//     }

//     // ===== GETTERS / SETTERS (TEST EXPECTED) =====

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public boolean isActive() {
//         return isActive;
//     }

//     public Boolean getIsActive() {
//         return isActive;
//     }

//     // ❗ TESTS + SERVICE EXPECT THIS
//     public void setActive(boolean active) {
//         this.isActive = active;
//     }

//     public User getPublisher() {
//         return publisher;
//     }

//     public void setPublisher(User publisher) {
//         this.publisher = publisher;
//     }

//     public Timestamp getCreatedAt() {
//         return createdAt;
//     }

//     public Timestamp getLastUpdatedAt() {
//         return lastUpdatedAt;
//     }

//     public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
//         this.lastUpdatedAt = lastUpdatedAt;
//     }

//     // optional but safe
//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public String getLocation() { return location; }
//     public void setLocation(String location) { this.location = location; }

//     public String getCategory() { return category; }
//     public void setCategory(String category) { this.category = category; }
// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String category;

    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User publisher;

    private Instant createdAt;
    private Instant lastUpdatedAt;

    // ===== JPA LIFECYCLE =====

    @PrePersist
    public void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.lastUpdatedAt = now;
        this.isActive = true;
    }

    @PreUpdate
    public void onUpdate() {
        this.lastUpdatedAt = Instant.now();
    }

    // ===== GETTERS / SETTERS (TEST EXPECTED) =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isActive() { return isActive; }
    public Boolean getIsActive() { return isActive; }

    // 🔴 REQUIRED by service + tests
    public void setActive(boolean active) {
        this.isActive = active;
    }

    public User getPublisher() { return publisher; }
    public void setPublisher(User publisher) { this.publisher = publisher; }

    public Instant getCreatedAt() { return createdAt; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }

    public void setLastUpdatedAt(Instant lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    // optional but safe
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}

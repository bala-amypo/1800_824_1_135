package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


import java.sql.Timestamp;


@Entity
public class EventUpdate
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String event;
    private String updateContent;
    private String updateType;
    private Timestamp postedAt;

    @PrePersist
    public void onCreate() {
        this.postedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
         return id; 
         }
    public String getEvent() {
         return event; 
         }
    public String getUpdateContext() {
         return updateContent;
          }
    public String getUpdateType() {
         return updateType;
          }
    
    
    public Timestamp getPostedAt() {
         return postedAt;
          }
    

    public void setId(Long id) { 
        this.id = id;
         }
    public void setEvent(String event) { 
        this.event = event;
         }
    public void setUpdateContent(String updateContent) { 
        this.updateContent = updateContent;
         }
    public void setUpdateType(String updateType) { 
        this.updateType = updateType; 
        }
     

     
    public EventUpdate(Long id, String event, String updateContent, String updateType,Timestamp postedAt) {

        this.id = id;
        this.event = event;
        this.updateContent = updateContent;
        this.updateType = updateType; 
        this.postedAt = postedAt;
    }
     public EventUpdate() {
    }
}


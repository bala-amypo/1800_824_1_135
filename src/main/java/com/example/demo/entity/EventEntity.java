package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class EventEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private String publisher;
    private boolean isActive;
    private Timestamp createdAt;

    public void setId(Long id)
    {
        
    }


}
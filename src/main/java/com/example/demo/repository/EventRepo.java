  package com.example.demo.repository;
import com.example.demo.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepo extends JpaRepository<EventEntity,Long>{



}
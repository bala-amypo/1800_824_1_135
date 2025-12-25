 
// package com.example.demo.service.impl;

// import com.example.demo.entity.EventUpdate;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.EventUpdateRepository;
// import com.example.demo.service.EventUpdateService;

// import org.springframework.stereotype.Service;

// import java.sql.Timestamp;
// import java.util.List;

// @Service
// public class EventUpdateServiceImpl implements EventUpdateService {

//     private final EventUpdateRepository updateRepository;
//     private final EventRepository eventRepository;

//     public EventUpdateServiceImpl(
//             EventUpdateRepository updateRepository,
//             EventRepository eventRepository
//     ) {
//         this.updateRepository = updateRepository;
//         this.eventRepository = eventRepository;
//     }

//     @Override
//     public EventUpdate publishUpdate(EventUpdate update) {
//         // ✅ EXACTLY WHAT TEST EXPECTS
//         update.setTimestamp(new Timestamp(System.currentTimeMillis()));
//         return updateRepository.save(update);
//     }

//     @Override
//     public EventUpdate getUpdateById(Long id) {
//         return updateRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<EventUpdate> getUpdatesForEvent(Long eventId) {
//         return updateRepository.findByEventIdOrderByTimestampAsc(eventId);
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

    private Timestamp timestamp;

    public Long getId() {
        return id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // ✅ THIS IS WHAT LINE 412 EXPECTS
    public Timestamp getTimestamp() {
        return timestamp;
    }

    // ✅ THIS IS WHAT LINE 412 EXPECTS
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @PrePersist
    public void onCreate() {
        if (this.timestamp == null) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
        }
    }
}

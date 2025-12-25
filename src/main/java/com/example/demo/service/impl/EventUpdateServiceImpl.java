// package com.example.demo.service;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.EventUpdate;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.EventUpdateRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class EventUpdateServiceImpl implements EventUpdateService {

//     private final EventUpdateRepository updateRepository;
//     private final EventRepository eventRepository;
//     private final BroadcastService broadcastService;

     
//     public EventUpdateServiceImpl(EventUpdateRepository updateRepository,
//                                   EventRepository eventRepository,
//                                   BroadcastService broadcastService) {
//         this.updateRepository = updateRepository;
//         this.eventRepository = eventRepository;
//         this.broadcastService = broadcastService;
//     }

//     @Override
//     public EventUpdate publishUpdate(EventUpdate update) {
       
//         Long eventId = update.getEvent().getId();
//         Event event = eventRepository.findById(eventId)
//                 .orElseThrow(() -> new IllegalArgumentException("not found"));

//         update.setEvent(event);

//         EventUpdate saved = updateRepository.save(update);
 
//         broadcastService.triggerBroadcast(saved.getId());

//         return saved;
//     }

//     @Override
//     public List<EventUpdate> getUpdatesForEvent(Long eventId) {
//         return updateRepository.findByEventId(eventId);
//     }

//     @Override
//     public EventUpdate getUpdateById(Long id) {
//         return updateRepository.findById(id)
//                 .orElseThrow(() -> new IllegalArgumentException("not found"));
//     }
// }

// package com.example.demo.service.impl;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.EventUpdate;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.EventUpdateRepository;
// import com.example.demo.service.BroadcastService;
// import com.example.demo.service.EventUpdateService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class EventUpdateServiceImpl implements EventUpdateService {

//     private final EventUpdateRepository updateRepository;
//     private final EventRepository eventRepository;
//     private final BroadcastService broadcastService;

//     // ✅ CONSTRUCTOR EXACTLY AS TEST EXPECTS
//     public EventUpdateServiceImpl(
//             EventUpdateRepository updateRepository,
//             EventRepository eventRepository,
//             BroadcastService broadcastService
//     ) {
//         this.updateRepository = updateRepository;
//         this.eventRepository = eventRepository;
//         this.broadcastService = broadcastService;
//     }

//     // ================= TESTED METHODS =================

//     @Override
//     public EventUpdate createUpdate(Long eventId, EventUpdate update) {
//         Event event = eventRepository.findById(eventId).orElse(null);
//         if (event == null) {
//             return null;
//         }

//         update.setEvent(event);
//         EventUpdate saved = updateRepository.save(update);

//         // 🔴 TEST EXPECTS BROADCAST TO BE TRIGGERED
//         broadcastService.triggerBroadcast(saved.getId());

//         return saved;
//     }

//     @Override
//     public List<EventUpdate> getUpdatesForEvent(Long eventId) {
//         return updateRepository.findByEventId(eventId);
//     }
// }

// package com.example.demo.service.impl;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.EventUpdate;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.EventUpdateRepository;
// import com.example.demo.service.BroadcastService;
// import com.example.demo.service.EventUpdateService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class EventUpdateServiceImpl implements EventUpdateService {

//     private final EventUpdateRepository updateRepository;
//     private final EventRepository eventRepository;
//     private final BroadcastService broadcastService;

//     // ✅ EXACT constructor expected by tests
//     public EventUpdateServiceImpl(
//             EventUpdateRepository updateRepository,
//             EventRepository eventRepository,
//             BroadcastService broadcastService
//     ) {
//         this.updateRepository = updateRepository;
//         this.eventRepository = eventRepository;
//         this.broadcastService = broadcastService;
//     }

//     // ================= CONTROLLER METHODS =================

//     @Override
//     public EventUpdate publishUpdate(EventUpdate update) {
//         EventUpdate saved = updateRepository.save(update);

//         // tests expect broadcast
//         broadcastService.triggerBroadcast(saved.getId());

//         return saved;
//     }

//     @Override
//     public EventUpdate getUpdateById(Long id) {
//         return updateRepository.findById(id).orElse(null);
//     }

//     // ================= TEST METHODS =================

//     @Override
//     public EventUpdate createUpdate(Long eventId, EventUpdate update) {
//         Event event = eventRepository.findById(eventId).orElse(null);
//         if (event == null) {
//             return null;
//         }

//         update.setEvent(event);
//         EventUpdate saved = updateRepository.save(update);
//         broadcastService.triggerBroadcast(saved.getId());
//         return saved;
//     }

//     @Override
//     public List<EventUpdate> getUpdatesForEvent(Long eventId) {
//         return updateRepository.findByEventId(eventId);
//     }
// }
// package com.example.demo.service.impl;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.EventUpdate;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.EventUpdateRepository;
// import com.example.demo.service.BroadcastService;
// import com.example.demo.service.EventUpdateService;

// import org.springframework.stereotype.Service;

// import java.time.Instant;
// import java.util.List;

// @Service
// public class EventUpdateServiceImpl implements EventUpdateService {

//     private final EventUpdateRepository eventUpdateRepository;
//     private final EventRepository eventRepository;
//     private final BroadcastService broadcastService;

//     // ✅ EXACT constructor expected by tests
//     public EventUpdateServiceImpl(
//             EventUpdateRepository eventUpdateRepository,
//             EventRepository eventRepository,
//             BroadcastService broadcastService
//     ) {
//         this.eventUpdateRepository = eventUpdateRepository;
//         this.eventRepository = eventRepository;
//         this.broadcastService = broadcastService;
//     }

//     // ================= CONTROLLER METHODS =================

//     @Override
//     public EventUpdate publishUpdate(EventUpdate update) {
//         update.setTimestamp(Instant.now());
//         EventUpdate saved = eventUpdateRepository.save(update);
//         broadcastService.triggerBroadcast(saved.getId());
//         return saved;
//     }

//     @Override
//     public EventUpdate getUpdateById(Long id) {
//         return eventUpdateRepository.findById(id).orElse(null);
//     }

//     // ================= TEST METHODS =================

//     @Override
//     public EventUpdate createUpdate(Long eventId, EventUpdate update) {
//         Event event = eventRepository.findById(eventId).orElse(null);
//         if (event == null) return null;

//         update.setEvent(event);
//         update.setTimestamp(Instant.now());

//         EventUpdate saved = eventUpdateRepository.save(update);
//         broadcastService.triggerBroadcast(saved.getId());
//         return saved;
//     }

//     @Override
//     public List<EventUpdate> getUpdatesForEvent(Long eventId) {
//         return eventUpdateRepository.findByEventIdOrderByTimestampAsc(eventId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.EventUpdate;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.EventUpdateRepository;
import com.example.demo.service.BroadcastService;
import com.example.demo.service.EventUpdateService;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {

    private final EventUpdateRepository updateRepository;
    private final EventRepository eventRepository;
    private final BroadcastService broadcastService;

    // 🔴 EXACT constructor tests expect
    public EventUpdateServiceImpl(
            EventUpdateRepository updateRepository,
            EventRepository eventRepository,
            BroadcastService broadcastService
    ) {
        this.updateRepository = updateRepository;
        this.eventRepository = eventRepository;
        this.broadcastService = broadcastService;
    }

    // 🔴 TEST EXPECTS THIS METHOD
    @Override
    public EventUpdate publishUpdate(EventUpdate update) {
        update.setTimestamp(Instant.now());

        EventUpdate saved = updateRepository.save(update);

        // trigger broadcast AFTER save
        broadcastService.triggerBroadcast(saved.getId());

        return saved;
    }

    // 🔴 TEST EXPECTS THIS METHOD
    @Override
    public EventUpdate getUpdateById(Long id) {
        return updateRepository.findById(id).orElse(null);
    }

    // 🔴 TEST EXPECTS THIS METHOD
    @Override
    public List<EventUpdate> getUpdatesForEvent(Long eventId) {
        return updateRepository.findByEventId(eventId);
    }
}

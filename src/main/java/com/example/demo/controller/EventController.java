// package com.example.demo.controller;

// import com.example.demo.entity.Event;
// import com.example.demo.service.EventService;
// import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

// import java.util.List;

// @RestController
// @RequestMapping("/api/events")
// public class EventController {

//     private final EventService eventService;

//     public EventController(EventService eventService) {
//         this.eventService = eventService;
//     }

//     @PostMapping
//     public Event createEvent(@RequestBody Event event) {
       
//         return eventService.createEvent(event);
//     }

//     @PutMapping("/{id}")
//     public Event updateEvent(@PathVariable Long id,
//                              @RequestBody Event event) {
//         return eventService.updateEvent(id, event);
//     }

//     @GetMapping("/{id}")
//     public Event getEvent(@PathVariable Long id) {
//         return eventService.getEventById(id);
//     }

//     @GetMapping("/active")
//     public List<Event> getActiveEvents() {
//         return eventService.getActiveEvents();
//     }

//     @PatchMapping("/{id}/deactivate")
//     public void deactivate(@PathVariable Long id) {
//         eventService.deactivateEvent(id);
//     }
// }
package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // ✅ Create event
    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    // ✅ Get event by ID
    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id) {
        return eventService.getById(id);
    }

    // ✅ Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // ✅ Deactivate event
    @PutMapping("/{id}/deactivate")
    public Event deactivateEvent(@PathVariable Long id) {
        return eventService.deactivateEvent(id);
    }
}

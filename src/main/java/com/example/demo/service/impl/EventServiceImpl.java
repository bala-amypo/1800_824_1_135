// // //  package com.example.demo.service;

// // // import com.example.demo.entity.Event;
// // // import com.example.demo.repository.EventRepository;
// // // import org.springframework.stereotype.Service;

// // // import java.util.List;

// // // @Service
// // // public class EventServiceImpl implements EventService {

// // //     private final EventRepository eventRepository;

// // //     public EventServiceImpl(EventRepository eventRepository) {
// // //         this.eventRepository = eventRepository;
// // //     }

// // //     @Override
// // //     public Event createEvent(Event event) {
// // //         return eventRepository.save(event);
// // //     }

// // //     @Override
// // //     public Event updateEvent(Long id, Event event) {
// // //         Event existing = getEventById(id);

// // //         existing.setTitle(event.getTitle());
// // //         existing.setDescription(event.getDescription());
// // //         existing.setLocation(event.getLocation());
// // //         existing.setCategory(event.getCategory());

// // //         return eventRepository.save(existing);
// // //     }

// // //     @Override
// // //     public Event getEventById(Long id) {
// // //         return eventRepository.findById(id)
// // //                 .orElseThrow(() -> new IllegalArgumentException("Event not found"));
// // //     }

// // //     @Override
// // //     public List<Event> getActiveEvents() {
// // //         return eventRepository.findByIsActiveTrue();
// // //     }

// // //     @Override
// // //     public void deactivateEvent(Long id) {
// // //         Event event = getEventById(id);
// // //         event.setIsActive(false);
// // //         eventRepository.save(event);
// // //     }
// // // }
// // // package com.example.demo.service.impl;

// // // import com.example.demo.entity.Event;
// // // import com.example.demo.repository.EventRepository;
// // // import com.example.demo.service.EventService;

// // // import org.springframework.stereotype.Service;

// // // import java.util.List;

// // // @Service
// // // public class EventServiceImpl implements EventService {

// // //     private final EventRepository eventRepository;

// // //     // ✅ Constructor EXACTLY as tests expect
// // //     public EventServiceImpl(EventRepository eventRepository) {
// // //         this.eventRepository = eventRepository;
// // //     }

// // //     // ✅ Used by tests
// // //     @Override
// // //     public Event save(Event event) {
// // //         return eventRepository.save(event);
// // //     }

// // //     // ✅ Used by tests
// // //     @Override
// // //     public Event getById(Long id) {
// // //         return eventRepository.findById(id).orElse(null);
// // //     }

// // //     // ✅ Used by tests
// // //     @Override
// // //     public List<Event> getAllEvents() {
// // //         return eventRepository.findAll();
// // //     }

// // //     // ✅ FIXED: uses setActive(), NOT setIsActive()
// // //     @Override
// // //     public Event deactivateEvent(Long id) {
// // //         Event event = eventRepository.findById(id).orElse(null);
// // //         if (event != null) {
// // //             event.setActive(false);   //  correct setter
// // //             eventRepository.save(event);
// // //         }
// // //         return event;
// // //     }
// // // }
// // // package com.example.demo.service.impl;

// // // import com.example.demo.entity.Event;
// // // import com.example.demo.repository.EventRepository;
// // // import com.example.demo.repository.UserRepository;
// // // import com.example.demo.service.EventService;

// // // import org.springframework.stereotype.Service;

// // // import java.util.List;

// // // @Service
// // // public class EventServiceImpl implements EventService {

// // //     private final EventRepository eventRepository;
// // //     private final UserRepository userRepository;

// // //     // ✅ EXACT constructor expected by tests
// // //     public EventServiceImpl(EventRepository eventRepository,
// // //                             UserRepository userRepository) {
// // //         this.eventRepository = eventRepository;
// // //         this.userRepository = userRepository;
// // //     }

// // //     // ✅ Test expects this method
// // //     @Override
// // //     public Event createEvent(Event event) {
// // //         return eventRepository.save(event);
// // //     }

// // //     // ✅ Test expects this method
// // //     @Override
// // //     public Event updateEvent(Long id, Event event) {
// // //         event.setId(id);
// // //         return eventRepository.save(event);
// // //     }

// // //     // ✅ Test expects this method
// // //     @Override
// // //     public List<Event> getActiveEvents() {
// // //         return eventRepository.findAll();
// // //     }
// // // }
// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Event;
// // import com.example.demo.repository.EventRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.EventService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class EventServiceImpl implements EventService {

// //     private final EventRepository eventRepository;
// //     private final UserRepository userRepository;

// //     // ✅ constructor EXACTLY as tests expect
// //     public EventServiceImpl(EventRepository eventRepository,
// //                             UserRepository userRepository) {
// //         this.eventRepository = eventRepository;
// //         this.userRepository = userRepository;
// //     }

// //     // ===== TEST METHODS =====

// //     @Override
// //     public Event createEvent(Event event) {
// //         return eventRepository.save(event);
// //     }

// //     @Override
// //     public Event updateEvent(Long id, Event event) {
// //         event.setId(id);
// //         return eventRepository.save(event);
// //     }

// //     @Override
// //     public List<Event> getActiveEvents() {
// //         return eventRepository.findAll();
// //     }

// //     // ===== CONTROLLER METHODS =====

// //     @Override
// //     public Event save(Event event) {
// //         return eventRepository.save(event);
// //     }

// //     @Override
// //     public Event getById(Long id) {
// //         return eventRepository.findById(id).orElse(null);
// //     }

// //     @Override
// //     public List<Event> getAllEvents() {
// //         return eventRepository.findAll();
// //     }

// //     @Override
// //     public Event deactivateEvent(Long id) {
// //         Event event = eventRepository.findById(id).orElse(null);
// //         if (event != null) {
// //             event.setActive(false);
// //             eventRepository.save(event);
// //         }
// //       return event;

// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.Role;
// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.EventService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class EventServiceImpl implements EventService {

//     private final EventRepository eventRepository;
//     private final UserRepository userRepository;

//     // 🔴 EXACT constructor expected by tests
//     public EventServiceImpl(EventRepository eventRepository,
//                             UserRepository userRepository) {
//         this.eventRepository = eventRepository;
//         this.userRepository = userRepository;
//     }

//     // ================= REQUIRED BY TESTS =================

//     @Override
//     public Event createEvent(Event event) {

//         Long publisherId = event.getPublisher().getId();

//         User publisher = userRepository.findById(publisherId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         if (publisher.getRole() != Role.PUBLISHER && publisher.getRole() != Role.ADMIN) {
//             throw new BadRequestException("Only PUBLISHER or ADMIN can create events");
//         }

//         event.setPublisher(publisher);
//         return eventRepository.save(event);
//     }

//     @Override
//     public Event updateEvent(Long id, Event updated) {

//         Event existing = eventRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

//         existing.setTitle(updated.getTitle());
//         existing.setDescription(updated.getDescription());
//         existing.setLocation(updated.getLocation());
//         existing.setCategory(updated.getCategory());

//         return eventRepository.save(existing);
//     }

//     @Override
//     public List<Event> getActiveEvents() {
//         return eventRepository.findByIsActiveTrue();
//     }

//     @Override
//     public void deactivateEvent(Long id) {

//         Event event = eventRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

//         event.setActive(false);
//         eventRepository.save(event);
//     }

//     // ================= OPTIONAL / CONTROLLER =================

//     @Override
//     public Event getById(Long id) {
//         return eventRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
//     }

//     @Override
//     public List<Event> getAllEvents() {
//         return eventRepository.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EventService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    // ✅ EXACT constructor expected by tests
    public EventServiceImpl(EventRepository eventRepository,
                            UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    // ================= REQUIRED BY TESTS =================

    @Override
    public Event createEvent(Event event) {

        Long publisherId = event.getPublisher().getId();

        User publisher = userRepository.findById(publisherId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (publisher.getRole() != Role.PUBLISHER && publisher.getRole() != Role.ADMIN) {
            throw new BadRequestException("Only PUBLISHER or ADMIN can create events");
        }

        event.setPublisher(publisher);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event updated) {

        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setLocation(updated.getLocation());
        existing.setCategory(updated.getCategory());

        return eventRepository.save(existing);
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByIsActiveTrue();
    }

    // 🔴 FIXED: MUST return Event (not void)
    @Override
    public Event deactivateEvent(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        event.setActive(false);
        return eventRepository.save(event);
    }

    // ================= CONTROLLER METHODS =================

    @Override
    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}

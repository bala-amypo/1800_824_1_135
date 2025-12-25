// package com.example.demo.service;

// import com.example.demo.entity.Event;

// import java.util.List;

// public interface EventService {

//     Event createEvent(Event event);

//     Event updateEvent(Long id, Event event);

//     Event getEventById(Long id);

//     List<Event> getActiveEvents();

//     void deactivateEvent(Long id);
// }
// package com.example.demo.service;

// import com.example.demo.entity.Event;
// import java.util.List;

// public interface EventService {

//     Event save(Event event);

//     Event getById(Long id);

//     List<Event> getAllEvents();

//     Event deactivateEvent(Long id);
// }
// package com.example.demo.service;

// import com.example.demo.entity.Event;
// import java.util.List;

// public interface EventService {

//     Event createEvent(Event event);

//     Event updateEvent(Long id, Event event);

//     List<Event> getActiveEvents();
// }
package com.example.demo.service;

import com.example.demo.entity.Event;
import java.util.List;

public interface EventService {

    // used by tests
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    List<Event> getActiveEvents();

    // used by controller
    Event save(Event event);
    Event getById(Long id);
    List<Event> getAllEvents();
    Event deactivateEvent(Long id);
    
}

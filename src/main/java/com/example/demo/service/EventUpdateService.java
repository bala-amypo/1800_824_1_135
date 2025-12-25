// package com.example.demo.service;

// import com.example.demo.entity.EventUpdate;

// import java.util.List;

// public interface EventUpdateService {

//     EventUpdate publishUpdate(EventUpdate update);

//     List<EventUpdate> getUpdatesForEvent(Long eventId);

//     EventUpdate getUpdateById(Long id);
// }

// package com.example.demo.service;

// import com.example.demo.entity.EventUpdate;
// import java.util.List;

// public interface EventUpdateService {

//     EventUpdate createUpdate(Long eventId, EventUpdate update);

//     List<EventUpdate> getUpdatesForEvent(Long eventId);
// }

// package com.example.demo.service;

// import com.example.demo.entity.EventUpdate;
// import java.util.List;

// public interface EventUpdateService {

//     // ✅ used by controller
//     EventUpdate publishUpdate(EventUpdate update);

//     // ✅ used by controller
//     EventUpdate getUpdateById(Long id);

//     // ✅ used by tests
//     EventUpdate createUpdate(Long eventId, EventUpdate update);

//     List<EventUpdate> getUpdatesForEvent(Long eventId);
// }
// package com.example.demo.service;

// import com.example.demo.entity.EventUpdate;
// import java.util.List;

// public interface EventUpdateService {

//     EventUpdate publishUpdate(EventUpdate update);

//     EventUpdate getUpdateById(Long id);

//     EventUpdate createUpdate(Long eventId, EventUpdate update);

//     List<EventUpdate> getUpdatesForEvent(Long eventId);
// }
package com.example.demo.service;

import com.example.demo.entity.EventUpdate;
import java.util.List;

public interface EventUpdateService {

    // 🔴 controller + tests expect these
    EventUpdate publishUpdate(EventUpdate update);

    EventUpdate getUpdateById(Long id);

    List<EventUpdate> getUpdatesForEvent(Long eventId);
}


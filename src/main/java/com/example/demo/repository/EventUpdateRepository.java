// package com.example.demo.repository;
// import com.example.demo.entity.EventUpdate;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface EventUpdateRepository extends JpaRepository<EventUpdate,Long>{

// List<EventUpdate> findByEventId(Long eventId);

// }

// package com.example.demo.repository;

// import com.example.demo.entity.EventUpdate;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

//     List<EventUpdate> findByEventIdOrderByTimestampAsc(Long eventId);
// }

// package com.example.demo.repository;

// import com.example.demo.entity.EventUpdate;
// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

//     // ✅ REQUIRED BY SERVICE + TESTS
//     List<EventUpdate> findByEventId(Long eventId);
// }
// package com.example.demo.repository;

// import com.example.demo.entity.EventUpdate;
// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface EventUpdateRepository
//         extends JpaRepository<EventUpdate, Long> {

//     List<EventUpdate> findByEventId(Long eventId);
// }

// package com.example.demo.repository;

// import com.example.demo.entity.EventUpdate;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

//     // 🔴 REQUIRED BY TESTS
//     List<EventUpdate> findByEventId(Long eventId);

//     // 🔴 REQUIRED BY TESTS
//     List<EventUpdate> findByEventIdOrderByTimestampAsc(Long eventId);
// }
// package com.example.demo.repository;

// import com.example.demo.entity.EventUpdate;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

//     // 🔴 TEST EXPECTS THIS METHOD
//     List<EventUpdate> findByEventId(Long eventId);
    

//     // 🔴 TEST EXPECTS THIS METHOD
//     List<EventUpdate> findAllByOrderByTimestampAsc();
// }

package com.example.demo.repository;

import com.example.demo.entity.EventUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventUpdateRepository extends JpaRepository<EventUpdate, Long> {

    // ✅ REQUIRED by tests
    List<EventUpdate> findByEventIdOrderByTimestampAsc(Long eventId);

    // ✅ REQUIRED by tests
    List<EventUpdate> findByEventId(Long eventId);

    // ✅ REQUIRED by tests
    List<EventUpdate> findAllByOrderByTimestampAsc();
}

// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     boolean existsByUserIdAndEventId(Long userId, Long eventId);

// //     List<Subscription> findByUserId(Long userId);

// //     List<Subscription> findByEventId(Long eventId);
// // }

// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;
// // import java.util.Optional;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     Optional<Subscription> findByUserIdAndEventId(Long userId, Long eventId);

// //     List<Subscription> findByUserId(Long userId);
// // }

// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     boolean existsByUserIdAndEventId(Long userId, Long eventId);

// //     void deleteByUserIdAndEventId(Long userId, Long eventId);

// //     List<Subscription> findByUserId(Long userId);
// // }
// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     boolean existsByUserIdAndEventId(Long userId, Long eventId);

// //     void deleteByUserIdAndEventId(Long userId, Long eventId);

// //     List<Subscription> findByUserId(Long userId);
// // }

// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     // ✅ REQUIRED BY TEST
// //     List<Subscription> findByEventId(Long eventId);

// //     // ✅ REQUIRED BY TEST
// //     List<Subscription> findByUserId(Long userId);

// //     // ✅ REQUIRED BY TEST
// //     void deleteByUserIdAndEventId(Long userId, Long eventId);

// //     // ✅ REQUIRED BY TEST
// //     boolean existsByUserIdAndEventId(Long userId, Long eventId);
// // }


// // package com.example.demo.repository;

// // import com.example.demo.entity.Subscription;
// // import org.springframework.data.jpa.repository.JpaRepository;

// // import java.util.List;

// // public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

// //     // ✅ REQUIRED BY TEST
// //     List<Subscription> findByEventId(Long eventId);

// //     // ✅ REQUIRED BY TEST
// //     List<Subscription> findByUserId(Long userId);

// //     // ✅ REQUIRED BY TEST
// //     Subscription findByUserIdAndEventId(Long userId, Long eventId);

// //     // ✅ REQUIRED BY TEST
// //     void deleteByUserIdAndEventId(Long userId, Long eventId);

// //     // ✅ REQUIRED BY TEST
// //     boolean existsByUserIdAndEventId(Long userId, Long eventId);
// // }


// package com.example.demo.repository;

// import com.example.demo.entity.Subscription;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;
// import java.util.Optional;

// public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

//     List<Subscription> findByEventId(Long eventId);

//     List<Subscription> findByUserId(Long userId);

//     Optional<Subscription> findByUserIdAndEventId(Long userId, Long eventId);

//     void deleteByUserIdAndEventId(Long userId, Long eventId);

//     boolean existsByUserIdAndEventId(Long userId, Long eventId);
// }


package com.example.demo.repository;

import com.example.demo.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByEventId(Long eventId);

    List<Subscription> findByUserId(Long userId);

    Optional<Subscription> findByUserIdAndEventId(Long userId, Long eventId);

    void deleteByUserIdAndEventId(Long userId, Long eventId);

    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}

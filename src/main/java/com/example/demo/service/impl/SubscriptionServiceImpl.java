// // package com.example.demo.service;

// // import com.example.demo.entity.Event;
// // import com.example.demo.entity.Subscription;
// // import com.example.demo.entity.User;
// // import com.example.demo.repository.EventRepository;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.repository.UserRepository;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;
// //     private final UserRepository userRepository;
// //     private final EventRepository eventRepository;

    
// //     public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
// //                                    UserRepository userRepository,
// //                                    EventRepository eventRepository) {
// //         this.subscriptionRepository = subscriptionRepository;
// //         this.userRepository = userRepository;
// //         this.eventRepository = eventRepository;
// //     }

// //     @Override
// //     public void subscribe(Long userId, Long eventId) {

// //         if (subscriptionRepository.existsByUserIdAndEventId(userId, eventId)) {
// //             throw new IllegalArgumentException("Already subscribed");
// //         }

// //         User user = userRepository.findById(userId)
// //                 .orElseThrow(() -> new IllegalArgumentException("not found"));

// //         Event event = eventRepository.findById(eventId)
// //                 .orElseThrow(() -> new IllegalArgumentException("not found"));

// //         Subscription subscription = new Subscription();
// //         subscription.setUser(user);
// //         subscription.setEvent(event);

// //         subscriptionRepository.save(subscription);
// //     }

// //     @Override
// //     public void unsubscribe(Long userId, Long eventId) {

// //         List<Subscription> subscriptions =
// //                 subscriptionRepository.findByUserId(userId);

// //         for (Subscription sub : subscriptions) {
// //             if (sub.getEvent().getId().equals(eventId)) {
// //                 subscriptionRepository.delete(sub);
// //                 return;
// //             }
// //         }

// //         throw new IllegalArgumentException("not found");
// //     }

// //     @Override
// //     public List<Subscription> getSubscriptionsForUser(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }

// //     @Override
// //     public boolean checkSubscription(Long userId, Long eventId) {
// //         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
// //     }
// // }
// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Subscription;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.service.SubscriptionService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;

// //     // ✔ Constructor EXACTLY as test expects
// //     public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
// //         this.subscriptionRepository = subscriptionRepository;
// //     }

// //     @Override
// //     public Subscription subscribe(Long userId, Long eventId) {
// //         Subscription sub = new Subscription();
// //         sub.setUserId(userId);
// //         sub.setEventId(eventId);
// //         return subscriptionRepository.save(sub);
// //     }

// //     @Override
// //     public boolean isSubscribed(Long userId, Long eventId) {
// //         return subscriptionRepository
// //                 .findByUserIdAndEventId(userId, eventId)
// //                 .isPresent();
// //     }

// //     @Override
// //     public List<Subscription> getUserSubscriptions(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }
// // }

// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Subscription;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.service.SubscriptionService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;

// //     public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
// //         this.subscriptionRepository = subscriptionRepository;
// //     }

// //     @Override
// //     public Subscription subscribe(Long userId, Long eventId) {
// //         Subscription sub = new Subscription();
// //         sub.setUserId(userId);
// //         sub.setEventId(eventId);
// //         return subscriptionRepository.save(sub);
// //     }

// //     @Override
// //     public void unsubscribe(Long userId, Long eventId) {
// //         subscriptionRepository
// //                 .findByUserIdAndEventId(userId, eventId)
// //                 .ifPresent(subscriptionRepository::delete);
// //     }

// //     @Override
// //     public boolean checkSubscription(Long userId, Long eventId) {
// //         return subscriptionRepository
// //                 .findByUserIdAndEventId(userId, eventId)
// //                 .isPresent();
// //     }

// //     @Override
// //     public List<Subscription> getSubscriptionsForUser(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }
// // }

// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Event;
// // import com.example.demo.entity.Subscription;
// // import com.example.demo.entity.User;
// // import com.example.demo.repository.EventRepository;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.SubscriptionService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;
// //     private final UserRepository userRepository;
// //     private final EventRepository eventRepository;

// //     // 🔴 Constructor EXACTLY as test expects
// //     public SubscriptionServiceImpl(
// //             SubscriptionRepository subscriptionRepository,
// //             UserRepository userRepository,
// //             EventRepository eventRepository
// //     ) {
// //         this.subscriptionRepository = subscriptionRepository;
// //         this.userRepository = userRepository;
// //         this.eventRepository = eventRepository;
// //     }

// //     @Override
// //     public Subscription subscribe(Long userId, Long eventId) {
// //         User user = userRepository.findById(userId).orElseThrow();
// //         Event event = eventRepository.findById(eventId).orElseThrow();

// //         Subscription subscription = new Subscription();
// //         subscription.setUser(user);     // ✅ NOT setUserId
// //         subscription.setEvent(event);   // ✅ NOT setEventId

// //         return subscriptionRepository.save(subscription);
// //     }

// //     @Override
// //     public void unsubscribe(Long userId, Long eventId) {
// //         subscriptionRepository.deleteByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public boolean checkSubscription(Long userId, Long eventId) {
// //         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public List<Subscription> getSubscriptionsForUser(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }
// // }
// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Event;
// // import com.example.demo.entity.Subscription;
// // import com.example.demo.entity.User;
// // import com.example.demo.repository.EventRepository;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.SubscriptionService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;
// //     private final UserRepository userRepository;
// //     private final EventRepository eventRepository;

// //     // ✅ EXACT constructor expected by tests
// //     public SubscriptionServiceImpl(
// //             SubscriptionRepository subscriptionRepository,
// //             UserRepository userRepository,
// //             EventRepository eventRepository
// //     ) {
// //         this.subscriptionRepository = subscriptionRepository;
// //         this.userRepository = userRepository;
// //         this.eventRepository = eventRepository;
// //     }

// //     @Override
// //     public Subscription subscribe(Long userId, Long eventId) {
// //         User user = userRepository.findById(userId).orElseThrow();
// //         Event event = eventRepository.findById(eventId).orElseThrow();

// //         Subscription subscription = new Subscription();
// //         subscription.setUser(user);
// //         subscription.setEvent(event);

// //         return subscriptionRepository.save(subscription);
// //     }

// //     @Override
// //     public void unsubscribe(Long userId, Long eventId) {
// //         subscriptionRepository.deleteByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public boolean checkSubscription(Long userId, Long eventId) {
// //         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public List<Subscription> getSubscriptionsForUser(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }
// // }


// // package com.example.demo.service.impl;

// // import com.example.demo.entity.Event;
// // import com.example.demo.entity.Subscription;
// // import com.example.demo.entity.User;
// // import com.example.demo.repository.EventRepository;
// // import com.example.demo.repository.SubscriptionRepository;
// // import com.example.demo.repository.UserRepository;
// // import com.example.demo.service.SubscriptionService;

// // import org.springframework.stereotype.Service;

// // import java.util.List;

// // @Service
// // public class SubscriptionServiceImpl implements SubscriptionService {

// //     private final SubscriptionRepository subscriptionRepository;
// //     private final UserRepository userRepository;
// //     private final EventRepository eventRepository;

// //     // ✅ EXACT constructor expected by tests
// //     public SubscriptionServiceImpl(
// //             SubscriptionRepository subscriptionRepository,
// //             UserRepository userRepository,
// //             EventRepository eventRepository
// //     ) {
// //         this.subscriptionRepository = subscriptionRepository;
// //         this.userRepository = userRepository;
// //         this.eventRepository = eventRepository;
// //     }

// //     @Override
// //     public Subscription subscribe(Long userId, Long eventId) {
// //         User user = userRepository.findById(userId).orElseThrow();
// //         Event event = eventRepository.findById(eventId).orElseThrow();

// //         Subscription subscription = new Subscription();
// //         subscription.setUser(user);
// //         subscription.setEvent(event);

// //         return subscriptionRepository.save(subscription);
// //     }

// //     @Override
// //     public void unsubscribe(Long userId, Long eventId) {
// //         subscriptionRepository.deleteByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public boolean checkSubscription(Long userId, Long eventId) {
// //         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
// //     }

// //     @Override
// //     public List<Subscription> getSubscriptionsForUser(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }

// //     // ✅ 🔴 REQUIRED BY TESTS (THIS WAS MISSING)
// //     @Override
// //     public List<Subscription> getUserSubscriptions(Long userId) {
// //         return subscriptionRepository.findByUserId(userId);
// //     }
// // }


// package com.example.demo.service.impl;

// import com.example.demo.entity.Event;
// import com.example.demo.entity.Subscription;
// import com.example.demo.entity.User;
// import com.example.demo.repository.EventRepository;
// import com.example.demo.repository.SubscriptionRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.SubscriptionService;

// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class SubscriptionServiceImpl implements SubscriptionService {

//     private final SubscriptionRepository subscriptionRepository;
//     private final UserRepository userRepository;
//     private final EventRepository eventRepository;

//     // ✅ EXACT constructor expected by tests
//     public SubscriptionServiceImpl(
//             SubscriptionRepository subscriptionRepository,
//             UserRepository userRepository,
//             EventRepository eventRepository
//     ) {
//         this.subscriptionRepository = subscriptionRepository;
//         this.userRepository = userRepository;
//         this.eventRepository = eventRepository;
//     }

//     @Override
//     public Subscription subscribe(Long userId, Long eventId) {
//         User user = userRepository.findById(userId).orElseThrow();
//         Event event = eventRepository.findById(eventId).orElseThrow();

//         Subscription subscription = new Subscription();
//         subscription.setUser(user);
//         subscription.setEvent(event);

//         return subscriptionRepository.save(subscription);
//     }

//     @Override
//     public void unsubscribe(Long userId, Long eventId) {
//         subscriptionRepository.deleteByUserIdAndEventId(userId, eventId);
//     }

//     @Override
//     public boolean checkSubscription(Long userId, Long eventId) {
//         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
//     }

//     @Override
//     public boolean isSubscribed(Long userId, Long eventId) {
//         return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
//     }

//     @Override
//     public List<Subscription> getSubscriptionsForUser(Long userId) {
//         return subscriptionRepository.findByUserId(userId);
//     }

//     @Override
//     public List<Subscription> getUserSubscriptions(Long userId) {
//         return subscriptionRepository.findByUserId(userId);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.Event;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.SubscriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SubscriptionService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    // 🔴 EXACT constructor expected by tests
    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            UserRepository userRepository,
            EventRepository eventRepository
    ) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    // ================= REQUIRED BY TESTS =================

    @Override
    public Subscription subscribe(Long userId, Long eventId) {

        if (subscriptionRepository.existsByUserIdAndEventId(userId, eventId)) {
            throw new BadRequestException("Already subscribed");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setEvent(event);

        return subscriptionRepository.save(subscription);
    }

    @Override
    public void unsubscribe(Long userId, Long eventId) {

        Subscription subscription = subscriptionRepository
                .findByUserIdAndEventId(userId, eventId)
                .orElseThrow(() ->
                        new BadRequestException("Subscription not found"));

        subscriptionRepository.delete(subscription);
    }

    @Override
    public boolean isSubscribed(Long userId, Long eventId) {
        return subscriptionRepository.existsByUserIdAndEventId(userId, eventId);
    }

    @Override
    public List<Subscription> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }
}

// package com.example.demo.controller;

// import com.example.demo.entity.Subscription;
// import com.example.demo.service.SubscriptionService;

// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;

// @RestController
// @RequestMapping("/api/subscriptions")
// public class SubscriptionController {

//     private final SubscriptionService subscriptionService;

//     public SubscriptionController(SubscriptionService subscriptionService) {
//         this.subscriptionService = subscriptionService;
//     }

//     @PostMapping("/{eventId}")
//     public void subscribe(@RequestParam Long userId,
//                           @PathVariable Long eventId) {
//         subscriptionService.subscribe(userId, eventId);
//     }

//     @DeleteMapping("/{eventId}")
//     public void unsubscribe(@RequestParam Long userId,
//                              @PathVariable Long eventId) {
//         subscriptionService.unsubscribe(userId, eventId);
//     }

//     @GetMapping("/user/{userId}")
//     public List<Subscription> getSubscriptions(@PathVariable Long userId) {
//         return subscriptionService.getSubscriptionsForUser(userId);
//     }

//     @GetMapping("/check/{userId}/{eventId}")
//     public boolean check(@PathVariable Long userId,
//                          @PathVariable Long eventId) {
//         return subscriptionService.checkSubscription(userId, eventId);
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // ✅ MUST return Subscription (not void)
    @PostMapping("/{eventId}")
    public Subscription subscribe(@RequestParam Long userId,
                                  @PathVariable Long eventId) {
        return subscriptionService.subscribe(userId, eventId);
    }

    @DeleteMapping("/{eventId}")
    public void unsubscribe(@RequestParam Long userId,
                            @PathVariable Long eventId) {
        subscriptionService.unsubscribe(userId, eventId);
    }

    // ✅ Required by tests
    @GetMapping("/user/{userId}")
    public List<Subscription> getSubscriptionsForUser(@PathVariable Long userId) {
        return subscriptionService.getSubscriptionsForUser(userId);
    }

    // ✅ Alias required by tests
    @GetMapping("/user/{userId}/all")
    public List<Subscription> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionService.getUserSubscriptions(userId);
    }

    @GetMapping("/check/{userId}/{eventId}")
    public boolean check(@PathVariable Long userId,
                         @PathVariable Long eventId) {
        return subscriptionService.checkSubscription(userId, eventId);
    }
}

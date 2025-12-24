// package com.example.demo.service;

// import com.example.demo.entity.BroadcastLog;

// import java.util.List;

// public interface BroadcastService {

//     void triggerBroadcast(Long updateId);

//     List<BroadcastLog> getLogsForUpdate(Long updateId);
// }

// package com.example.demo.service;

// public interface BroadcastService {

//     void broadcastUpdate(Long eventUpdateId);

//     void recordDelivery(Long updateId, Long userId, boolean delivered);
// }
// package com.example.demo.service;

// import java.util.List;

// public interface BroadcastService {

//     // Already required by tests
//     void broadcastUpdate(Long eventUpdateId);

//     void recordDelivery(Long updateId, Long userId, boolean delivered);

//     //  REQUIRED by BroadcastController & EventUpdateServiceImpl
//     void triggerBroadcast(Long eventUpdateId);

//     List<String> getLogsForUpdate(Long eventUpdateId);
// }
package com.example.demo.service;

import com.example.demo.entity.BroadcastLog;
import java.util.List;

public interface BroadcastService {

    void broadcastUpdate(Long eventUpdateId);

    void recordDelivery(Long updateId, Long userId, boolean delivered);

    void triggerBroadcast(Long eventUpdateId);

    // 🔴 MUST be BroadcastLog, NOT String
    List<BroadcastLog> getLogsForUpdate(Long eventUpdateId);
}

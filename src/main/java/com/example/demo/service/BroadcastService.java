// package com.example.demo.service;

// import com.example.demo.entity.BroadcastLog;

// import java.util.List;

// public interface BroadcastService {

//     void triggerBroadcast(Long updateId);

//     List<BroadcastLog> getLogsForUpdate(Long updateId);
// }

package com.example.demo.service;

public interface BroadcastService {

    void broadcastUpdate(Long eventUpdateId);

    void recordDelivery(Long updateId, Long userId, boolean delivered);
}

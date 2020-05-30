package cn.acey.mvc2cleanarch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(name = "${feign.notificationCenter.name}",
    url = "${feign.notificationCenter.url}")
@Service
public interface NotificationServiceFeign {
    @GetMapping("api/notifications/users/{userId}")
    List<Map> getNotificationUnRead(@PathVariable("userId") Long userId, @RequestParam("status") String status);

    @PostMapping("/api/notifications")
    List addNotification(@RequestBody Map notification);
}

package cn.acey.mvc2cleanarch.adapter.outbound.gateway.notification;

import cn.acey.mvc2cleanarch.domain.notification.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "${feign.notificationCenter.name}",
    url = "${feign.notificationCenter.url}")
@Service
public interface NotificationServiceFeign {
    @GetMapping("api/notifications/users/{userId}")
    List<NotificationDto> getNotificationUnRead(@PathVariable("userId") Long userId, @RequestParam("status") String status);

    @PostMapping("/api/notifications")
    void addNotification(@RequestBody NotificationDto notification);
}

package cn.acey.mvc2cleanarch.adapter.outbound.gateway.notification;

import cn.acey.mvc2cleanarch.application.gateway.notification.NotificationDto;
import cn.acey.mvc2cleanarch.application.gateway.notification.NotificationService;
import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationServiceFeign notificationServiceFeign;

    public void markAsExcellentNotification(long teacherId, long noteId) throws BusinessException {
        notificationServiceFeign.addNotification(
            NotificationDto.build(
                noteId,
                teacherId,
                "%s 日记被标注为优秀日志"
            ));
    }

    public void cancelExcellentNotification(Long teacherId, Long noteId) throws BusinessException {
        notificationServiceFeign.addNotification(
            NotificationDto.build(
                noteId,
                teacherId,
                "%s 日记被标注为优秀日志"
            )
        );
    }
}

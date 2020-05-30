package cn.acey.mvc2cleanarch.application.gateway.notification;

import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;

public interface NotificationService {

    void markAsExcellentNotification(long teacherId, long noteId) throws BusinessException;

    void cancelExcellentNotification(Long teacherId, Long noteId) throws BusinessException;

}

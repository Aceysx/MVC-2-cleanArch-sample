package cn.acey.mvc2cleanarch.domain.notification;

import cn.acey.mvc2cleanarch.adapter.outbound.gateway.notification.NotificationServiceFeign;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.note.Note;
import cn.acey.mvc2cleanarch.domain.notification.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {
    @Autowired
    private NoteService noteService;
    @Autowired
    private NotificationServiceFeign notificationServiceFeign;

    public void markAsExcellentNotification(long teacherId, long noteId) throws BusinessException {
        Map data = buildNotification(teacherId, noteId, "%s 日记被标注为优秀日志");
        notificationServiceFeign.addNotification(data);
    }

    public void cancelExcellentNotification(Long teacherId, Long noteId) throws BusinessException {
        Map data = buildNotification(teacherId, noteId, "%s 日记被取消优秀日志");
        notificationServiceFeign.addNotification(data);
    }

    private Map buildNotification(Long teacherId, Long noteId, String s) throws BusinessException {
        Note note = noteService.findNote(noteId);
        Map data = new HashMap();
        data.put("studentId", note.getAuthorId());
        data.put("noteId", noteId);
        data.put("teacherId", teacherId);
        data.put("content", String.format(s, note.getTitle()));
        return data;
    }
}

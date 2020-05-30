package cn.acey.mvc2cleanarch.domain.context.excellentNote;

import cn.acey.mvc2cleanarch.application.gateway.notification.NotificationService;
import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcellentNoteService {
    @Autowired
    private ExcellentNoteRepository excellentNoteRepository;
    @Autowired
    private NotificationService notificationService;

    public void deleteExcellentNote(Long id) {
        if (isExist(id)) {
            excellentNoteRepository.deleteByNoteId(id);
        }
    }

    public ExcellentNote markAsExcellent(Long noteId, Long userId) throws BusinessException {
        if (isExist(noteId)) {
            throw new BusinessException("this note is marked excellent already");
        }
        ExcellentNote excellentNote = new ExcellentNote(noteId, userId);
        excellentNote = excellentNoteRepository.save(excellentNote);
        notificationService.markAsExcellentNotification(userId, noteId);
        return excellentNote;
    }

    private boolean isExist(long noteId) {
        return excellentNoteRepository.isExist(noteId);
    }

    public void cancelExcellentNote(Long id, Long userId) throws BusinessException {
        deleteExcellentNote(id);
        notificationService.cancelExcellentNotification(userId, id);
    }
}

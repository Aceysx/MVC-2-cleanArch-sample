package cn.acey.mvc2cleanarch.domain.excellentNote;

import cn.acey.mvc2cleanarch.domain.notification.NotificationService;
import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.ExcellentNote;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.adapter.outbound.persistence.excellentNote.ExcellentNoteRepository;
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

    public ExcellentNote markAsExcellent(Long noteId, User user) throws BusinessException {
        long teacherId = user.getId();
        if (isExist(noteId)) {
            throw new BusinessException("this note is marked excellent already");
        }
        ExcellentNote excellentNote = new ExcellentNote(noteId, teacherId);
        excellentNote = excellentNoteRepository.save(excellentNote);
        notificationService.markAsExcellentNotification(teacherId, noteId);
        return excellentNote;
    }

    private boolean isExist(long noteId) {
        return excellentNoteRepository.findByNoteId(noteId).isPresent();
    }

    public void cancelExcellentNote(Long id, User user) throws BusinessException {
        if (user.isTeacher()) {
            deleteExcellentNote(id);
            notificationService.cancelExcellentNotification(user.getId(), id);
        }
    }
}

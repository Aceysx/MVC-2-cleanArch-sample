package cn.acey.mvc2cleanarch.domain.excellentNote;

import cn.acey.mvc2cleanarch.application.gateway.notification.NotificationService;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.adapter.outbound.user.UserDto;
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

    public ExcellentNote markAsExcellent(Long noteId, UserDto userDto) throws BusinessException {
        long teacherId = userDto.getId();
        if (isExist(noteId)) {
            throw new BusinessException("this note is marked excellent already");
        }
        ExcellentNote excellentNote = new ExcellentNote(noteId, teacherId);
        excellentNote = excellentNoteRepository.save(excellentNote);
        notificationService.markAsExcellentNotification(teacherId, noteId);
        return excellentNote;
    }

    private boolean isExist(long noteId) {
        return excellentNoteRepository.isExist(noteId);
    }

    public void cancelExcellentNote(Long id, UserDto userDto) throws BusinessException {
        if (userDto.isTeacher()) {
            deleteExcellentNote(id);
            notificationService.cancelExcellentNotification(userDto.getId(), id);
        }
    }
}

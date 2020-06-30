package cn.acey.mvc2cleanarch.application.usecases.excellentNoteUseCase;

import cn.acey.mvc2cleanarch.domain.context.excellentNote.ExcellentNote;
import cn.acey.mvc2cleanarch.domain.context.excellentNote.ExcellentNoteService;
import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EditExcellentNoteUseCase {
    @Autowired
    private ExcellentNoteService excellentNoteService;

    public ExcellentNote markAsExcellent(Long noteId, Long userId) throws BusinessException {
        return excellentNoteService.markAsExcellent(noteId, userId);
    }

    public void cancelExcellentNote(Long id, Long userId) throws BusinessException {
        excellentNoteService.cancelExcellentNote(id, userId);
    }
}

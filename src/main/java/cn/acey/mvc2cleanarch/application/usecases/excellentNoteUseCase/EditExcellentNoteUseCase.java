package cn.acey.mvc2cleanarch.application.usecases.excellentNoteUseCase;

import cn.acey.mvc2cleanarch.adapter.outbound.user.UserDto;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNote;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNoteService;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EditExcellentNoteUseCase {
    @Autowired
    private ExcellentNoteService excellentNoteService;

    public ExcellentNote markAsExcellent(Long noteId, UserDto userDto) throws BusinessException {
        return excellentNoteService.markAsExcellent(noteId, userDto);
    }

    public void cancelExcellentNote(Long id, UserDto userDto) throws BusinessException {
        excellentNoteService.cancelExcellentNote(id, userDto);
    }
}

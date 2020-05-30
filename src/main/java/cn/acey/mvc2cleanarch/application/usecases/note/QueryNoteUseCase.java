package cn.acey.mvc2cleanarch.application.usecases.note;

import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.note.Note;
import cn.acey.mvc2cleanarch.domain.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class QueryNoteUseCase {
    @Autowired
    private NoteService noteService;

    public Note findNote(Long id) throws BusinessException {
        return noteService.findNote(id);
    }
}

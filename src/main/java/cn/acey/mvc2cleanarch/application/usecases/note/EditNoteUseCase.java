package cn.acey.mvc2cleanarch.application.usecases.note;

import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.context.note.Note;
import cn.acey.mvc2cleanarch.domain.context.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EditNoteUseCase {
    @Autowired
    private NoteService noteService;

    public Note create(Long userId, String title, String content) {
        return noteService.create(userId, title, content);
    }

    public void updateNote(Long userId, Long noteId, String title, String content) throws BusinessException {
        noteService.updateNote(userId, noteId, title, content);
    }

    public void delete(Long noteId, Long userId) throws BusinessException {
        noteService.delete(noteId, userId);
    }
}

package cn.acey.mvc2cleanarch.domain.context.note;

import cn.acey.mvc2cleanarch.domain.context.excellentNote.ExcellentNoteService;
import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ExcellentNoteService excellentNoteService;

    public Note create(Long authorId, String title, String content) {
        Note note = new Note(title, content, authorId);
        return noteRepository.save(note);
    }

    public Note findNote(Long id) throws BusinessException {
        return noteRepository.findById(id);
    }

    @Transactional
    public void updateNote(Long userId, Long noteId, String title, String content) throws BusinessException {
        Note found = findNote(noteId);
        if (!Objects.equals(found.getAuthorId(), userId)) {
            throw new BusinessException("error args");
        }
        found.update(title, content);
    }

    public void delete(Long noteId, Long userId) throws BusinessException {
        Note found = findNote(noteId);
        if (!Objects.equals(found.getAuthorId(), userId)) {
            throw new BusinessException("error args");
        }
        excellentNoteService.deleteExcellentNote(found.getId());
    }
}

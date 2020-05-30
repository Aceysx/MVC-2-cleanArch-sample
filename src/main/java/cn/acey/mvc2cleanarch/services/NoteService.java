package cn.acey.mvc2cleanarch.services;

import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.Note;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private ExcellentNoteService excellentNoteService;

    public Note create(Map data, User user) {
        String title = data.get("title").toString();
        String content = data.get("content").toString();
        Long authorId = user.getId();
        Note note = new Note(title, content, authorId);
        return noteRepository.save(note);
    }

    public Note findNote(Long id) throws BusinessException {
        return noteRepository.findById(id).orElseThrow(
            () -> new BusinessException(
                String.format("current note is not found with id %s", id)
            )
        );
    }

    @Transactional
    public void updateNote(Note note, User user) throws BusinessException {
        Note found = findNote(note.getId());
        if (!Objects.equals(found.getAuthorId(), user.getId())) {
            throw new BusinessException("error args");
        }
        found.update(note);
    }

    public void delete(Long id, User user) throws BusinessException {
        Note found = findNote(id);
        if (!Objects.equals(found.getAuthorId(), user.getId())) {
            throw new BusinessException("error args");
        }
        excellentNoteService.deleteExcellentNote(found.getId());
    }
}

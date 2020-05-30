package cn.acey.mvc2cleanarch.domain.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.CreateNoteRequest;
import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.UpdateNoteRequest;
import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.Note;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.adapter.outbound.persistence.note.NoteRepository;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNoteService;
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

    public Note create(CreateNoteRequest createNoteRequest, User user) {
        Long authorId = user.getId();
        Note note = new Note(createNoteRequest.getTitle(), createNoteRequest.getContent(), authorId);
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
    public void updateNote(Long id, UpdateNoteRequest updateNoteRequest, User user) throws BusinessException {
        Note found = findNote(id);
        if (!Objects.equals(found.getAuthorId(), user.getId())) {
            throw new BusinessException("error args");
        }
        found.update(updateNoteRequest);
    }

    public void delete(Long id, User user) throws BusinessException {
        Note found = findNote(id);
        if (!Objects.equals(found.getAuthorId(), user.getId())) {
            throw new BusinessException("error args");
        }
        excellentNoteService.deleteExcellentNote(found.getId());
    }
}

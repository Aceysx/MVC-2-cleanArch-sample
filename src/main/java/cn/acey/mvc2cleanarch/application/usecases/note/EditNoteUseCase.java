package cn.acey.mvc2cleanarch.application.usecases.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.CreateNoteRequest;
import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.UpdateNoteRequest;
import cn.acey.mvc2cleanarch.adapter.outbound.user.UserDto;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.note.Note;
import cn.acey.mvc2cleanarch.domain.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EditNoteUseCase {
    @Autowired
    private NoteService noteService;

    public Note create(CreateNoteRequest createNoteRequest, UserDto userDto) {
        return noteService.create(createNoteRequest, userDto);
    }

    public void updateNote(Long id, UpdateNoteRequest updateNoteRequest, UserDto userDto) throws BusinessException {
        noteService.updateNote(id,updateNoteRequest,userDto);
    }

    public void delete(Long id, UserDto userDto) throws BusinessException {
        noteService.delete(id, userDto);
    }
}

package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.auth.Auth;
import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.Note;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.domain.notification.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("")
    public ResponseEntity publishNote(@RequestBody CreateNoteRequest createNoteRequest,
                                      @Auth User user) {
        Note note = noteService.create(createNoteRequest, user);
        return new ResponseEntity(CreateNoteResponse.build(("api/notes/" + note.getId())), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) throws BusinessException {
        Note note = noteService.findNote(id);
        return ResponseEntity.created(URI.create("api/notes/" + note.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody UpdateNoteRequest updateNoteRequest,
                                 @Auth User user) throws BusinessException {
        noteService.updateNote(id,updateNoteRequest, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id,
                                 @Auth User user) throws BusinessException {
        noteService.delete(id, user);
        return ResponseEntity.noContent().build();
    }

}

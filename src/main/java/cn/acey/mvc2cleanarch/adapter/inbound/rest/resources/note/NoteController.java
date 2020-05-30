package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.auth.Auth;
import cn.acey.mvc2cleanarch.adapter.outbound.user.UserDto;
import cn.acey.mvc2cleanarch.application.usecases.note.EditNoteUseCase;
import cn.acey.mvc2cleanarch.application.usecases.note.QueryNoteUseCase;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.note.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/notes")
public class NoteController {
    @Autowired
    private QueryNoteUseCase queryNoteUseCase;
    @Autowired
    private EditNoteUseCase editNoteUseCase;

    @PostMapping("")
    public ResponseEntity publishNote(@RequestBody CreateNoteRequest createNoteRequest,
                                      @Auth UserDto userDto) {
        Note note = editNoteUseCase.create(createNoteRequest, userDto);
        return new ResponseEntity(CreateNoteResponse.build(("api/notes/" + note.getId())), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) throws BusinessException {
        Note note = queryNoteUseCase.findNote(id);
        return ResponseEntity.created(URI.create("api/notes/" + note.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody UpdateNoteRequest updateNoteRequest,
                                 @Auth UserDto userDto) throws BusinessException {
        editNoteUseCase.updateNote(id, updateNoteRequest, userDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id,
                                 @Auth UserDto userDto) throws BusinessException {
        editNoteUseCase.delete(id, userDto);
        return ResponseEntity.noContent().build();
    }

}

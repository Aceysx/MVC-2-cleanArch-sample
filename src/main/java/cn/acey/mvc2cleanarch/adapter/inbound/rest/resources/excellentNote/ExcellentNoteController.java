package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.excellentNote;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.auth.Auth;
import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNote;
import cn.acey.mvc2cleanarch.adapter.outbound.user.UserDto;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notes/excellent")
public class ExcellentNoteController {
    @Autowired
    private ExcellentNoteService excellentNoteService;

    @PostMapping("")
    public ResponseEntity mark(@RequestBody CreateExcellentNoteRequest createExcellentNoteRequest,
                               @Auth UserDto userDto) throws BusinessException {
        ExcellentNote note = excellentNoteService.markAsExcellent(createExcellentNoteRequest.getNoteId(), userDto);
        return new ResponseEntity(CreateExcellentNoteResponse.build(String.format("api/notes/%s", note.getId())), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity cancel(@PathVariable Long id,
                                 @Auth UserDto userDto) throws BusinessException {
        excellentNoteService.cancelExcellentNote(id, userDto);
        return ResponseEntity.noContent().build();
    }

}

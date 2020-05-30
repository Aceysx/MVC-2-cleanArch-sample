package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.excellentNote;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.auth.Auth;
import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.ExcellentNote;
import cn.acey.mvc2cleanarch.models.User;
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
                               @Auth User user) throws BusinessException {
        ExcellentNote note = excellentNoteService.markAsExcellent(createExcellentNoteRequest.getNoteId(), user);
        return new ResponseEntity(CreateExcellentNoteResponse.build(String.format("api/notes/%s", note.getId())), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity cancel(@PathVariable Long id,
                                 @Auth User user) throws BusinessException {
        excellentNoteService.cancelExcellentNote(id, user);
        return ResponseEntity.noContent().build();
    }

}

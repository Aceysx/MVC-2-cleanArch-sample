package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.excellentNote;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.auth.Auth;
import cn.acey.mvc2cleanarch.adapter.inbound.rest.dto.UserDto;
import cn.acey.mvc2cleanarch.application.usecases.excellentNoteUseCase.EditExcellentNoteUseCase;
import cn.acey.mvc2cleanarch.domain.context.excellentNote.ExcellentNote;
import cn.acey.mvc2cleanarch.domain.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/notes/excellent")
public class ExcellentNoteController {
    @Autowired
    private EditExcellentNoteUseCase editExcellentNoteUseCase;

    @PostMapping("")
    public ResponseEntity mark(@RequestBody CreateExcellentNoteRequest createExcellentNoteRequest,
                               @Auth UserDto userDto) throws BusinessException {
        ExcellentNote note = editExcellentNoteUseCase.markAsExcellent(createExcellentNoteRequest.getNoteId(), userDto.getId());
        return new ResponseEntity(CreateExcellentNoteResponse.build(String.format("api/notes/%s", note.getId())), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity cancel(@PathVariable Long id,
                                 @Auth UserDto userDto) throws BusinessException {
        editExcellentNoteUseCase.cancelExcellentNote(id, userDto.getId());
        return ResponseEntity.noContent().build();
    }

}

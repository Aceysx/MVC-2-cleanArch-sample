package cn.acey.mvc2cleanarch.controllers;

import cn.acey.mvc2cleanarch.auth.Auth;
import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.ExcellentNote;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.services.ExcellentNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("api/notes/excellent")
public class ExcellentNoteController {
    @Autowired
    private ExcellentNoteService excellentNoteService;

    @PostMapping("")
    public ResponseEntity mark(@RequestBody Map excellentNoteMap,
                               @Auth User user) throws BusinessException {
        ExcellentNote note = excellentNoteService.markAsExcellent(excellentNoteMap, user);
        return ResponseEntity.created(URI.create("api/notes/" + note.getNoteId())).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity cancel(@PathVariable Long id,
                                 @Auth User user) throws BusinessException {
        excellentNoteService.cancelExcellentNote(id, user);
        return ResponseEntity.noContent().build();
    }

}

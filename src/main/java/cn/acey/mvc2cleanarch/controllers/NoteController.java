package cn.acey.mvc2cleanarch.controllers;

import cn.acey.mvc2cleanarch.models.BusinessException;
import cn.acey.mvc2cleanarch.models.Note;
import cn.acey.mvc2cleanarch.models.User;
import cn.acey.mvc2cleanarch.auth.Auth;
import cn.acey.mvc2cleanarch.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("")
    public ResponseEntity publishNote(@RequestBody Map noteMap,
                                      @Auth User user) {
        Note note = noteService.create(noteMap, user);
        return ResponseEntity.created(URI.create("api/notes/" + note.getId())).build();
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable Long id) throws BusinessException {
        Note note = noteService.findNote(id);
        return ResponseEntity.created(URI.create("api/notes/" + note.getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody Note note,
                                 @Auth User user) throws BusinessException {
        noteService.updateNote(note,user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id,
                                 @Auth User user) throws BusinessException {
        noteService.delete(id,user);
        return ResponseEntity.noContent().build();
    }

}

package cn.acey.mvc2cleanarch.adapter.outbound.persistence.note;


import cn.acey.mvc2cleanarch.domain.exception.BusinessException;
import cn.acey.mvc2cleanarch.domain.note.Note;
import cn.acey.mvc2cleanarch.domain.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteRepositoryImpl implements NoteRepository {
    @Autowired
    private NoteRepositoryVendor noteRepositoryVendor;

    @Override
    public Note save(Note note) {
        return NotePO.domain(
            noteRepositoryVendor.save(NotePO.of(note))
        );

    }

    @Override
    public Note findById(Long id) throws BusinessException {
        NotePO notePO = noteRepositoryVendor.findById(id).orElseThrow(
            () -> new BusinessException(
                String.format("current note is not found with id %s", id)
            )
        );
        return NotePO.domain(notePO);
    }
}

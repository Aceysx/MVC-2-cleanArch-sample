package cn.acey.mvc2cleanarch.adapter.outbound.persistence.excellentNote;


import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNote;
import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcellentNoteRepositoryImpl implements ExcellentNoteRepository {
    @Autowired
    private ExcellentNoteRepositoryVendor excellentNoteRepositoryVendor;

    @Override
    public void deleteByNoteId(Long id) {
        excellentNoteRepositoryVendor.deleteByNoteId(id);
    }

    @Override
    public ExcellentNote save(ExcellentNote excellentNote) {
        return ExcellentNotePO.domain(
            excellentNoteRepositoryVendor.save(ExcellentNotePO.of(excellentNote))
        );
    }

    @Override
    public boolean isExist(long noteId) {
        return excellentNoteRepositoryVendor.findByNoteId(noteId).isPresent();
    }
}

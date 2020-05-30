package cn.acey.mvc2cleanarch.domain.excellentNote;


public interface ExcellentNoteRepository {
    void deleteByNoteId(Long id);

    ExcellentNote save(ExcellentNote excellentNote);

    boolean isExist(long noteId);
}

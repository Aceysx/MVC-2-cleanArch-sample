package cn.acey.mvc2cleanarch.domain.context.excellentNote;


public interface ExcellentNoteRepository {
    void deleteByNoteId(Long id);

    ExcellentNote save(ExcellentNote excellentNote);

    boolean isExist(long noteId);
}

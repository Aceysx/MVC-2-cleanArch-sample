package cn.acey.mvc2cleanarch.repositories;


import cn.acey.mvc2cleanarch.models.ExcellentNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExcellentNoteRepository extends JpaRepository<ExcellentNote, Long> {
    void deleteByNoteId(Long id);

    Optional<Object> findByNoteId(long noteId);
}

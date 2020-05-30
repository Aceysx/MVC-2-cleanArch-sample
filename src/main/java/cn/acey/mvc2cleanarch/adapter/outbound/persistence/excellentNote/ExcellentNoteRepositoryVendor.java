package cn.acey.mvc2cleanarch.adapter.outbound.persistence.excellentNote;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExcellentNoteRepositoryVendor extends JpaRepository<ExcellentNotePO, Long> {
    void deleteByNoteId(Long id);

    Optional<Object> findByNoteId(long noteId);
}

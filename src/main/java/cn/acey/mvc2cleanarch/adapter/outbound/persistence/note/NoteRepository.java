package cn.acey.mvc2cleanarch.adapter.outbound.persistence.note;


import cn.acey.mvc2cleanarch.domain.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}

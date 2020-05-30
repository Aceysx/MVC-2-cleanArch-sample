package cn.acey.mvc2cleanarch.repositories;


import cn.acey.mvc2cleanarch.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {
}

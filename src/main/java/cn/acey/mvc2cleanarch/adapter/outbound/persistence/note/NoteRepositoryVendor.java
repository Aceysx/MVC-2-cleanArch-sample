package cn.acey.mvc2cleanarch.adapter.outbound.persistence.note;


import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepositoryVendor extends JpaRepository<NotePO, Long> {
}

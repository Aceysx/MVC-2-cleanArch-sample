package cn.acey.mvc2cleanarch.adapter.outbound.persistence.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.UpdateNoteRequest;
import cn.acey.mvc2cleanarch.domain.note.Note;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class NotePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Long authorId;

    public NotePO(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        createTime = new Date();
    }

    public static NotePO of(Note note) {
        return new NotePO(note.getTitle(), note.getContent(), note.getAuthorId());
    }

    public static Note domain(NotePO note) {
        return new Note(note.getTitle(), note.getContent(), note.getAuthorId());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void update(UpdateNoteRequest note) {
        this.title = note.getTitle();
        this.content = note.getContent();
    }
}

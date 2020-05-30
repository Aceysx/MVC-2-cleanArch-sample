package cn.acey.mvc2cleanarch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Long authorId;

    public Note(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        createTime = new Date();
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

    public void update(Note note) {
        this.title = note.getTitle();
        this.content = note.getContent();
    }
}

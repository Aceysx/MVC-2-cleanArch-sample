package cn.acey.mvc2cleanarch.domain.note;

import cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note.UpdateNoteRequest;

import java.util.Date;

public class Note {
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

    public void update(UpdateNoteRequest note) {
        this.title = note.getTitle();
        this.content = note.getContent();
    }
}

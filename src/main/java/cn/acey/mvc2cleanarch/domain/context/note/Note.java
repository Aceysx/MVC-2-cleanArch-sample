package cn.acey.mvc2cleanarch.domain.context.note;

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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

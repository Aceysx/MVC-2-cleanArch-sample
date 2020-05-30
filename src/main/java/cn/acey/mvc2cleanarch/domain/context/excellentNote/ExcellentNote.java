package cn.acey.mvc2cleanarch.domain.context.excellentNote;

import java.util.Date;

public class ExcellentNote {
    private Long id;
    private Long noteId;
    private Long teacherId;
    private Date createTime;

    public ExcellentNote(long noteId, long teacherId) {
        this.createTime = new Date();
        this.noteId = noteId;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public Long getNoteId() {
        return noteId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public Date getCreateTime() {
        return createTime;
    }
}

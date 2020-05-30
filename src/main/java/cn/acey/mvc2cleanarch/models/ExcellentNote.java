package cn.acey.mvc2cleanarch.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ExcellentNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

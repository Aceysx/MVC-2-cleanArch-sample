package cn.acey.mvc2cleanarch.adapter.outbound.persistence.excellentNote;

import cn.acey.mvc2cleanarch.domain.excellentNote.ExcellentNote;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ExcellentNotePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long noteId;
    private Long teacherId;
    private Date createTime;

    public ExcellentNotePO(long noteId, long teacherId) {
        this.createTime = new Date();
        this.noteId = noteId;
        this.teacherId = teacherId;
    }

    public static ExcellentNotePO of(ExcellentNote excellentNote) {
        return new ExcellentNotePO(excellentNote.getNoteId(), excellentNote.getTeacherId());
    }

    public static ExcellentNote domain(ExcellentNotePO excellentNote) {
        return new ExcellentNote(excellentNote.getNoteId(), excellentNote.getTeacherId());
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

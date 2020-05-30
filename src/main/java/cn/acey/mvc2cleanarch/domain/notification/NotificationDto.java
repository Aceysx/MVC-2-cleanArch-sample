package cn.acey.mvc2cleanarch.domain.notification;

public class NotificationDto {
    private Long noteId;
    private Long teacherId;
    private String content;

    public NotificationDto(long noteId, long teacherId, String content) {

        this.noteId = noteId;
        this.teacherId = teacherId;
        this.content = content;
    }

    public static NotificationDto build(long noteId, long teacherId, String content) {
        return new NotificationDto(noteId, teacherId, content);
    }

    public Long getNoteId() {
        return noteId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public String getContent() {
        return content;
    }
}

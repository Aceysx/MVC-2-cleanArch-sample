package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.note;

public class CreateNoteResponse {
    private String uri;

    public CreateNoteResponse(String uri) {
        this.uri = uri;
    }

    public static CreateNoteResponse build(String uri) {
        return new CreateNoteResponse(uri);
    }
}

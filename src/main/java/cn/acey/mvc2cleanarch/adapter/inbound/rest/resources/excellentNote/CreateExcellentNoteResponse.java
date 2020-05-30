package cn.acey.mvc2cleanarch.adapter.inbound.rest.resources.excellentNote;

public class CreateExcellentNoteResponse {
    private String uri;

    public CreateExcellentNoteResponse(String uri) {
        this.uri = uri;
    }

    public static CreateExcellentNoteResponse build(String uri) {
        return new CreateExcellentNoteResponse(uri);
    }
}

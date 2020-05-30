package cn.acey.mvc2cleanarch.models;

public class BusinessException extends Exception {
    public BusinessException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}

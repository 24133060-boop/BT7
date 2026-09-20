package vn.iostar.model;

public class Response {
    private Boolean status;
    private String message;
    private Object data;

    // Constructor không tham số
    public Response() {
    }

    // Constructor 3 tham số
    public Response(Boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getter và Setter cho status
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // Getter và Setter cho message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter và Setter cho data (Dùng cho Mục 5 AJAX)
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // Tương thích ngược với Mục 3 (Giúp code cũ gọi getBody/setBody không bị lỗi)
    public Object getBody() {
        return data;
    }

    public void setBody(Object body) {
        this.data = body;
    }
}
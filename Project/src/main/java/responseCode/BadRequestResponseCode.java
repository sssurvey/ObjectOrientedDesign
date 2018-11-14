package responseCode;

public class BadRequestResponseCode implements ResponseCodeContract{

    private static final int STATUS = 400;
    private String type;
    private String title;
    private String instance;
    private String detail;

    // default
    public BadRequestResponseCode() {
        this.type = "Bad Request";
        this.title = "Your request is BAD";
        this.detail = "Unknown error";
        this.instance = "/.";
    }

    public BadRequestResponseCode(String type, String title, String instance, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.instance = instance;
    }
}
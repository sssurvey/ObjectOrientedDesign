package responseCode;

public class NotFoundResponseCode implements ResponseCodeContract{

    private static final int STATUS = 404;
    private String type;
    private String title;
    private String instance;
    private String detail;

    public NotFoundResponseCode() {
        this.type = "Page not found";
        this.title = "Not Found";
        this.detail = "The data you requested is not found";
        this.instance = "/.";
    }

    public NotFoundResponseCode(String type, String title, String instance, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.instance = instance;
    }
}
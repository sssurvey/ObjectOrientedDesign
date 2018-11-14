package responseCode;

public class OkResponseCode implements ResponseCodeContract{

    private static final int STATUS = 200;
    private String type;
    private String title;
    private String instance;
    private String detail;

    public OkResponseCode() {
        this.type = "Everything is OK";
        this.title = "O.K.";
        this.detail = "No issues";
        this.instance = "/.";
    }

    public OkResponseCode(String type, String title, String instance, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.instance = instance;
    }
}
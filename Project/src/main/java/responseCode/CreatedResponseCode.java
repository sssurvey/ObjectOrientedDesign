package responseCode;

public class CreatedResponseCode implements ResponseCodeContract{

    private static final int STATUS = 201;
    private String type;
    private String title;
    private String instance;
    private String detail;

    public CreatedResponseCode() {
        this.type = "Everything is OK and Created";
        this.title = "created O.K.";
        this.detail = "Created";
        this.instance = "/.";
    }

    public CreatedResponseCode(String type, String title, String instance, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.instance = instance;
    }
}
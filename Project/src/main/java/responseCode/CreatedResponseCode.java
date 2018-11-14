package responseCode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

public class CreatedResponseCode implements ResponseCodeContract {

    private String type;
    private String title;
    private String instance;
    private String detail;
    private int status;

    public CreatedResponseCode() {
        this.type = "Everything is OK and Created";
        this.title = "created O.K.";
        this.detail = "Created";
        this.status = StatusCodes.CREATED_OK.getCode();
        this.instance = "";
    }

    public CreatedResponseCode(String type, String title, String detail, HttpServletRequest request) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.status = StatusCodes.BAD_REQUEST.getCode();
        this.instance = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }
}
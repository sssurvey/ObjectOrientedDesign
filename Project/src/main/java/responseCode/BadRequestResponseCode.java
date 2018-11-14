package responseCode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

public class BadRequestResponseCode implements ResponseCodeContract {

    private String type;
    private String title;
    private String instance;
    private String detail;
    private int status;

    // default
    public BadRequestResponseCode() {
        this.type = "Bad Request";
        this.title = "Your request is BAD";
        this.detail = "Unknown error";
        this.status = StatusCodes.BAD_REQUEST.getCode();
        this.instance = "";
    }

    public BadRequestResponseCode(String type, String title, HttpServletRequest request, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.status = StatusCodes.BAD_REQUEST.getCode();
        this.instance = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }
}
package responseCode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

public class NotFoundResponseCode implements ResponseCodeContract {

    private String type;
    private String title;
    private String instance;
    private String detail;
    private int status;

    public NotFoundResponseCode() {
        this.type = "Page not found";
        this.title = "Not Found";
        this.detail = "The data you requested is not found";
        this.status = StatusCodes.NOT_FOUND.getCode();
        this.instance = "";
    }

    public NotFoundResponseCode(String type, String title, HttpServletRequest request, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.status = StatusCodes.NOT_FOUND.getCode();
        this.instance = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }
}
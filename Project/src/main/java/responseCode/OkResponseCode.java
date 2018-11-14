package responseCode;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerMapping;

public class OkResponseCode implements ResponseCodeContract {

    private String type;
    private String title;
    private String instance;
    private String detail;
    private int status;

    public OkResponseCode() {
        this.type = "Everything is OK";
        this.title = "O.K.";
        this.detail = "No issues";
        this.status = StatusCodes.OK.getCode();
        this.instance = "";
    }

    public OkResponseCode(String type, String title, HttpServletRequest request, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.status = StatusCodes.BAD_REQUEST.getCode();
        this.instance = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    }
}
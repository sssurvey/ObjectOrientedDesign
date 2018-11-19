package jsonUtil;

import com.google.gson.Gson;

import responseCode.ResponseCodeContract;

public class ResponseJsonParser {
    public static String toJson(ResponseCodeContract responseCodeContract) {
        Gson gson = new Gson();
        return gson.toJson(responseCodeContract);
    }
}
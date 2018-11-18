package jsonUtil;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.orderModel.OrderModel;

public class OrderToJsonConvertor {
    public static String orderToJsonOidResponse(OrderModel orderModel) {
        Gson gson = new Gson();
        JsonObject oidReturn = new JsonObject();
        oidReturn.addProperty("oid", orderModel.getOid());
        return gson.toJson(oidReturn);
    }
}
package jsonUtil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.orderModel.OrderModel;
import model.vehicleModel.VehicleModel;
import model.visitorModel.VisitorModel;
import util.NumberFormatter;

public class OrderValidator {
    public OrderModel orderValidation(String orderJSON) throws Exception {
        OrderModel orderModel = jsonParser(orderJSON);
        return orderModel;
    }

    private OrderModel jsonParser(String orderJSON) throws Exception {

        VehicleModel vehicleModel;
        VisitorModel visitorModel;

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(orderJSON);

        String pid;

        if (jsonElement.isJsonObject()) {

            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonObject vehicleObject = jsonObject.getAsJsonObject("vehicle");
            JsonObject visitorObject = jsonObject.getAsJsonObject("visitor");
            JsonObject visitorPaymentInfoObject = visitorObject.getAsJsonObject("payment_info");

            pid = NumberFormatter.formatToThreeDigitStringPid(jsonObject.get("pid").getAsInt());

            vehicleModel = new VehicleModel(vehicleObject.get("state").getAsString(),
                    vehicleObject.get("plate").getAsString(), vehicleObject.get("type").getAsString());

            visitorModel = new VisitorModel(visitorObject.get("name").getAsString(),
                    visitorObject.get("email").getAsString());

            visitorModel.setupVisitorPaymentInfoModel(visitorPaymentInfoObject.get("card").getAsString(),
                    visitorPaymentInfoObject.get("name_on_card").getAsString(),
                    visitorPaymentInfoObject.get("expiration_date").getAsString(),
                    visitorPaymentInfoObject.get("zip").getAsInt());

            return new OrderModel(pid, vehicleModel, visitorModel);
        }

        throw new Exception("Order Failed to pass validation");

    }
}
package jsonUtil;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.orderModel.OrderModel;
import util.PriceCalculator;

public class OrderToJsonConvertor {
    public static String orderToJsonOidResponse(OrderModel orderModel) {
        Gson gson = new Gson();
        JsonObject oidReturn = new JsonObject();
        oidReturn.addProperty("oid", orderModel.getOid());
        return gson.toJson(oidReturn);
    }

    public static String convertListOrderModelToOutputJSON(List<OrderModel> list) {
        Gson gson = new Gson();
        List<AllOrderReturnModel> allOrderReturnModelList = new ArrayList<>();
        for (OrderModel orderModel : list) {
            allOrderReturnModelList.add(new AllOrderReturnModel(orderModel));
        }
        return gson.toJson(allOrderReturnModelList);
    }

    private static class AllOrderReturnModel {

        private String oid;
        private String pid;
        private String date;
        private String type;
        private int amount;

        private AllOrderReturnModel(OrderModel orderModel) {
            this.oid = orderModel.getOid();
            this.pid = orderModel.getPid();
            this.date = orderModel.getDate();
            this.type = orderModel.getVehicleModel().getType();
            this.amount = PriceCalculator.getPrice(orderModel);
        }
    }
}
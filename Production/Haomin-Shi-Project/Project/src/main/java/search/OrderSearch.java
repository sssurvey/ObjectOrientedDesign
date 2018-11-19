package search;

import java.util.ArrayList;
import java.util.List;

import jsonUtil.OrderToJsonConvertor;
import model.orderModel.OrderModel;
import storage.StorageEntity;

public class OrderSearch {

    public static List<OrderModel> search(String key) {
        
        List<OrderModel> matchModels = new ArrayList<>();

        for (OrderModel orderModel : StorageEntity.ALL_ORDERS) {
            String orderModelString = OrderToJsonConvertor.orderToJsonDetailed(orderModel);
            if (orderModelString.contains(key)) {
                matchModels.add(orderModel);
            }
        }
        return matchModels;
    }
}
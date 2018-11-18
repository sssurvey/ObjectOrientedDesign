package util;

import java.util.Map;

import model.orderModel.OrderModel;
import park.Park;
import storage.Storage;
import storage.StorageContract;

public class PriceCalculator {

    // this will calculate the price of the order based on the vechicle type and the
    // plate
    public static int getPrice(OrderModel orderModel) {

        StorageContract storageContract = new Storage();
        String vehicleType = orderModel.getVehicleModel().getType();
        String vehicleState = orderModel.getVehicleModel().getState();
        String destinationParkPid = orderModel.getPid();
        Park park = storageContract.getParkByPid(destinationParkPid);
        if (park == null)
            return 0;
        Map parkPrices = park.getPaymentInfoModel().getPricesMap();
        String region = park.getLocationInfoModel().getRegion();
        String[] temArr = region.split(" ");
        String parkState = (Character.toString(temArr[1].charAt(0)) + Character.toString(temArr[1].charAt(1)))
                .toUpperCase();
        if (vehicleState.equals(parkState)) {
            int[] prices = (int[]) parkPrices.get(vehicleType);
            return prices[0];
        } else {
            int[] prices = (int[]) parkPrices.get(vehicleType);
            return prices[1];
        }
    }
}
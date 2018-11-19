package model.parkModel;

import java.util.HashMap;
import java.util.Map;

import model.vehicleModel.*;

public class PaymentInfoModel {

    private VehicleTypeInfoModel vechicleTypeInfoModel;

    private Map<String, int[]> pricesMap = new HashMap<>();

    public PaymentInfoModel() {
    }

    /**
     * @return the licensePlate int[]
     */
    public int[] getPlatePrices(String carType) {
        return pricesMap.get(carType);
    }

    /**
     * @return the vechicleType
     */
    public VehicleTypeInfoModel getVechicleTypeInfoModel() {
        return vechicleTypeInfoModel;
    }

    /**
     * @return the pricesMap
     */
    public Map<String, int[]> getPricesMap() {
        return pricesMap;
    }

    public void addPrices(String carType, int[] platePrices) {
        pricesMap.put(carType, platePrices);
    }
}
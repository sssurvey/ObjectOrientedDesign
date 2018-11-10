package model.parkModel;

import model.vehicleModel.*;

public class PaymentInfoModel {

    private int[] platePrices = new int[2];
    private VehicleTypeInfoModel vechicleTypeInfoModel;

    public PaymentInfoModel(VehicleTypeInfoModel vehicleTypeInfoModel, int[] plate) {
        this.vechicleTypeInfoModel = vehicleTypeInfoModel;

        // TODO: This should be dynamically chaged based on the licience plate of the
        // vechiles
        this.platePrices = plate;
    }

    /**
     * @return the licensePlate
     */
    public int[] getPlatePrices() {
        return platePrices;
    }

    /**
     * @return the vechicleType
     */
    public VehicleTypeInfoModel getVechicleTypeInfoModel() {
        return vechicleTypeInfoModel;
    }

    /**
     * @param platePrices the platePrices to set
     */
    public void setPlatePrices(int[] platePrices) {
        this.platePrices = platePrices;
    }
}
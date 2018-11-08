package model.parkModel;

import model.vehicleModel.*;

public class PaymentInfoModel {

    private int[] licensePlate = new int[2];
    private VehicleTypeInfoModel vechicleTypeInfoModel;

    public PaymentInfoModel(VehicleTypeInfoModel vehicleTypefInfoModel, int[] plate) {
        this.vechicleTypeInfoModel = vehicleTypefInfoModel;

        // TODO: This should be dynamically chaged based on the licience plate of the
        // vechiles
        this.licensePlate[0] = plate[0]; // parking price for the in state viechle price
        this.licensePlate[1] = plate[1]; // price for the out of state vehicles
    }

    /**
     * @return the licensePlate
     */
    public int[] getLicensePlate() {
        return licensePlate;
    }

    /**
     * @return the vechicleType
     */
    public VehicleTypeInfoModel getVechicleTypeInfoModel() {
        return vechicleTypeInfoModel;
    }
}
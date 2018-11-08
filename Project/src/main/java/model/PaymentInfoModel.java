package model;

public class PaymentInfoModel {

    private int[] licensePlate = new int[2];
    private VehicleTypeInfoModel vechicleTypeInfoModel;

    public PaymentInfoModel(VehicleTypeInfoModel vehicleTypefInfoModel, int[] plate) {
        this.vechicleTypeInfoModel = vehicleTypefInfoModel;
        this.licensePlate[0] = plate[0];
        this.licensePlate[1] = plate[1];
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
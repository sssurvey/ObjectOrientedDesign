package park;

import model.parkModel.LocationInfoModel;
import model.parkModel.ParkModel;
import model.parkModel.PaymentInfoModel;
import model.vehicleModel.VehicleTypeInfoModel;

public class Park {

    // this is suppose to be a wrapper class that handles what a park do
    // this class will also be creating park objects

    private ParkModel parkModel;

    public Park(String name, String region, String address, String phone, String web, float[] geo,
            VehicleTypeInfoModel vehicleTypeInfoModel, int[] plate) {
        this.parkModel = new ParkModel();
        this.parkModel.setLocationInfoModel(new LocationInfoModel(name, region, address, phone, web, geo));
        this.parkModel.setPaymentInfoModel(new PaymentInfoModel(vehicleTypeInfoModel, plate));

    }

    /**
     * @param locationInfoModel the locationInfoModel to set
     */
    public void setLocationInfoModel(LocationInfoModel locationInfoModel) {
        this.parkModel.setLocationInfoModel(locationInfoModel);
    }

    /**
     * @param paymentInfoModel the paymentInfoModel to set
     */
    public void setPaymentInfoModel(PaymentInfoModel paymentInfoModel) {
        this.parkModel.setPaymentInfoModel(paymentInfoModel);
    }

    /**
     * @return the locationInfoModel
     */
    public LocationInfoModel getLocationInfoModel() {
        return this.parkModel.getLocationInfoModel();
    }

    /**
     * @return the parkModel
     */
    public ParkModel getParkModel() {
        return parkModel;
    }

    /**
     * @return the paymentInfoModel
     */
    public PaymentInfoModel getPaymentInfoModel() {
        return this.parkModel.getPaymentInfoModel();
    }

    /**
     * @return the PID
     */
    public String getPid() {
        return this.parkModel.getPid();
    }

}
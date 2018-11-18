package model.orderModel;

import model.vehicleModel.VehicleModel;
import model.visitorModel.VisitorModel;
import util.DateHelper;
import util.IdGenerator;
import util.NumberFormatter;

public class OrderModel {

    private String pid;
    private String oid;
    private String date;
    private int amount;
    private VehicleModel vehicleModel;
    private VisitorModel visitorModel;
    private PaymentProcessingStatus paymentProcessingStatus;

    public OrderModel(String pid, VehicleModel vehicleModel, VisitorModel visitorModel) {
        this.pid = pid;
        this.oid = NumberFormatter.formatToTenDigitStringOid(IdGenerator.generateOid());
        this.vehicleModel = vehicleModel;
        this.visitorModel = visitorModel;
        this.date = DateHelper.addDateStamp();
        this.paymentProcessingStatus = new PaymentProcessingStatus();
    }

    public OrderModel() {
        this.date = DateHelper.addDateStamp();
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @param vehicleModel the vehicleModel to set
     */
    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * @param visitorModel the visitorModel to set
     */
    public void setVisitorModel(VisitorModel visitorModel) {
        this.visitorModel = visitorModel;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @return the vehicleModel
     */
    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the visitorModel
     */
    public VisitorModel getVisitorModel() {
        return visitorModel;
    }

    /**
     * @return the paymentProcessingStatus
     */
    public PaymentProcessingStatus getPaymentProcessingStatus() {
        return paymentProcessingStatus;
    }

    public class PaymentProcessingStatus {

        private String transatctionId;
        private String date;

        public PaymentProcessingStatus() {
            this.transatctionId = NumberFormatter.formatToFifTeenDigitStringTid(IdGenerator.generateTid());
            this.date = DateHelper.addDateStamp();
        }

        /**
         * @return the date
         */
        public String getDate() {
            return date;
        }

        /**
         * @return the transatctionId
         */
        public String getTransatctionId() {
            return transatctionId;
        }
    }
}
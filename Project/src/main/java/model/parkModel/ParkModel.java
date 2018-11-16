package model.parkModel;

import util.*;

public class ParkModel {

	// a special string for park as a ref
	// TODO Need a PID generator, maybe not in this class
	private LocationInfoModel locationInfoModel;
	private PaymentInfoModel paymentInfoModel;
	private String pid;

	public ParkModel() {
		this.pid = NumberFormatter.formatToThreeDigitStringPid(IdGenerator.generatePid());
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	/**
	 * @param locationInfoModel the locationInfoModel to set
	 */
	public void setLocationInfoModel(LocationInfoModel locationInfoModel) {
		this.locationInfoModel = locationInfoModel;
	}

	/**
	 * @param paymentInfoModel the paymentInfoModel to set
	 */
	public void setPaymentInfoModel(PaymentInfoModel paymentInfoModel) {
		this.paymentInfoModel = paymentInfoModel;
	}

	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * @return the locationInfoModel
	 */
	public LocationInfoModel getLocationInfoModel() {
		return locationInfoModel;
	}

	/**
	 * @return the paymentInfoModel
	 */
	public PaymentInfoModel getPaymentInfoModel() {
		return paymentInfoModel;
	}
}
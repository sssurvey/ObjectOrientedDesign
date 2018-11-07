package model;

public class ParkModel {

	// a special string for park as a ref
	// TODO Payment INFO
	private LocationInfoModel locationInfoModel;
	private String pid;

	public ParkModel() {
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}

	public ParkModel create() {
		return new ParkModel();
	}

	/**
	 * @param locationInfoModel the locationInfoModel to set
	 */
	public void setLocationInfoModel(LocationInfoModel locationInfoModel) {
		this.locationInfoModel = locationInfoModel;
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
}
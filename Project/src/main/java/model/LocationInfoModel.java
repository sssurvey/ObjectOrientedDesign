package model;

public class LocationInfoModel {

	private String name;
	private String region;
	private String address;
	private String phone;
	private String web;
	// Geo lat and lng, [lat, lng]
	private float[] geo = new float[2];

	public LocationInfoModel(String name, String region, String address, String phone, String web, float[] geo) {
		this.name = name;
		this.region = region;
		this.address = address;
		this.phone = phone;
		this.web = web;
		// TODO .clone() might not be needed
		this.geo = geo.clone();
	}

	// TODO add getter method when needed
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * @param geo the geo to set
	 */
	public void setGeo(float[] geo) {
		this.geo = geo;
	}
}
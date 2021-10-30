package Model;
public abstract class MotoVehicle {
	protected String vehicleID;
	protected String brand;
	protected int rantPerDay;
	public int rest;
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRantPerDay() {
		return rantPerDay;
	}
	public void setRantPerDay(int rantPerDay) {
		this.rantPerDay = rantPerDay;
	}

	public MotoVehicle(String vehicleID, String brand, int rantPerDay) {
		super();
		this.vehicleID = vehicleID;
		this.brand = brand;
		this.rantPerDay = rantPerDay;
	}
	public MotoVehicle() {
		
	}
	

	public abstract float calRent(int days);
	
}

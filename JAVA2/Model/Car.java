package Model;
public class Car extends MotoVehicle {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Car(String vehicleID, String brand, int rantPerDay, String type) {
		super(vehicleID, brand, rantPerDay);
		this.type = type;
	}
	public Car() {
		
	}
	@Override
	public float calRent(int days) {
		float price = this.getRantPerDay()*days;
		if(days > 7 && days <=30) {
			price *= 0.9f;
		}else if(days > 30 && days <= 150) {
			price *=0.8f;
		}else if(days > 150) {
			price *= 0.7f;
		}
		return price;

	}

	

}

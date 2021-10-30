package Model;

public class Bus extends MotoVehicle {
	private int seatCount;

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Bus(String vehicleID, String brand, int rantPerDay, int seatCount) {
		super(vehicleID, brand, rantPerDay);
		this.seatCount = seatCount;
	}
	public Bus() {
		
	}


	@Override
	public float calRent(int days) {
		float price = this.getRantPerDay()*days;
		if(days >= 3 && days <7) {
			price *= 0.9f;
		}else if(days >= 7 && days < 30) {
			price *=0.8f;
		}else if(days >= 30 && days < 150) {
			price *= 0.7f;
		}else if(days >= 150) {
			price *=0.6f;
		}
		return price;
	}

	
	
}

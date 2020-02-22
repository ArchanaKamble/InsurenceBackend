package com.lti.entities;


public class CarDetails{
	private int carId;
	private int ageOfCar;
	
	public CarDetails() {
		super();
	}

	public CarDetails(int carId, int ageOfCar) {
		super();
		this.carId = carId;
		this.ageOfCar = ageOfCar;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getAgeOfCar() {
		return ageOfCar;
	}

	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}

	@Override
	public String toString() {
		return "CarDetails [carId=" + carId + ", ageOfCar=" + ageOfCar + "]";
	}
	
	
}

package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIKEMODEL")
public class BikeModel {

	@Id
	@Column(name = "VEHICLEID")
	private int carId;
	
	@Column(name = "MANUFACTURER")
	private String brand;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "VARIANT")
	private String variant;

	@Column(name = "MARKETPRICE")
	private String marketPrice;
	
	public BikeModel() {
		super();
	}

	public BikeModel(int carId, String brand, String model, String variant, String marketPrice) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.variant = variant;
		this.marketPrice = marketPrice;
	}



	public String getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}

	

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}

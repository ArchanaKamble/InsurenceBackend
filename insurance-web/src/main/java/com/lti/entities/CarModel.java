package com.lti.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "CARMODEL")
public class CarModel {

	@Id
	@Column(name = "CARID")
	private int carId;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "VARIANT")
	private String variant;
	
	@Column(name = "MARKETPRICE")
	private String marketPrice;

	public CarModel() {
		super();
	}


	public CarModel(int carId, String brand, String model, String variant, String marketPrice) {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	@Override
	public String toString() {
		return "CarModel [carId=" + carId + ", brand=" + brand + ", model=" + model + ", variant=" + variant
				+ ", marketPrice=" + marketPrice + "]";
	}

	
	

}

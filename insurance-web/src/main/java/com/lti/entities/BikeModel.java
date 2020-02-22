package com.lti.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BIKEMODEL")
public class BikeModel {

	@Id
	@Column(name = "bikeID")
	private int bikeId;
	
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "VARIANT")
	private String variant;

	@Column(name = "MARKETPRICE")
	private String marketPrice;
	
	public BikeModel() {
		super();
	}


	public BikeModel(int bikeId, String manufacturer, String model, String variant, String marketPrice) {
		super();
		this.bikeId = bikeId;
		this.manufacturer = manufacturer;
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

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
		return "BikeModel [bikeId=" + bikeId + ", manufacturer=" + manufacturer + ", model=" + model + ", variant="
				+ variant + ", marketPrice=" + marketPrice + "]";
	}
	
}

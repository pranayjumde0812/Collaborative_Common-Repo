package com.vehicle;

import java.util.Date;

import com.color.Color;

public class Vehicle {
	private String chasisNo;
	private double price,pollutionLevel;
	private Date manufactureDate, insuranceExpiryDate;
	private Color color;
	public Vehicle(String chasisNo, double price, double pollutionLevel, Date manufactureDate,
			Date insuranceExpiryDate,Color color) {
		super();
		this.chasisNo = chasisNo;
		this.price = price;
		this.pollutionLevel = pollutionLevel;
		this.manufactureDate = manufactureDate;
		this.insuranceExpiryDate = insuranceExpiryDate;
		this.color = color;

	}
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPollutionLevel() {
		return pollutionLevel;
	}
	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public Date getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}
	public void setInsuranceExpiryDate(Date insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}
	public Color getColor() {
		return color;
	}
	public void setInsuranceExpiryDate(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", price=" + price + ", pollutionLevel=" + pollutionLevel
				+ ", manufactureDate=" + manufactureDate + ", insuranceExpiryDate=" + insuranceExpiryDate + ", color="
				+ color + "]";
	}
	
	
	
	
}

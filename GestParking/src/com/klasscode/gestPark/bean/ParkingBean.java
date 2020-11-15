package com.klasscode.gestPark.bean;

import java.util.Date;

public class ParkingBean {

	private int id;
	private VehiculeBean vehicule;
	private String parkingCode;
	private Date parkingDate;
	private String action;
	private double parkingCharge;
	private String remarque;

	public ParkingBean(int id, VehiculeBean vehicule, String parkingCode, Date parkingDate, String action,
			double parkingCharge, String remarque) {
		super();
		this.id = id;
		this.vehicule = vehicule;
		this.parkingCode = parkingCode;
		this.parkingDate = parkingDate;
		this.action = action;
		this.parkingCharge = parkingCharge;
		this.remarque = remarque;
	}

	public ParkingBean(VehiculeBean vehicule, String parkingCode, Date parkingDate, String action, double parkingCharge,
			String remarque) {
		super();
		this.vehicule = vehicule;
		this.parkingCode = parkingCode;
		this.parkingDate = parkingDate;
		this.action = action;
		this.parkingCharge = parkingCharge;
		this.remarque = remarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VehiculeBean getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeBean vehicule) {
		this.vehicule = vehicule;
	}

	public String getParkingCode() {
		return parkingCode;
	}

	public void setParkingCode(String parkingCode) {
		this.parkingCode = parkingCode;
	}

	public Date getParkingDate() {
		return parkingDate;
	}

	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public double getParkingCharge() {
		return parkingCharge;
	}

	public void setParkingCharge(double parkingCharge) {
		this.parkingCharge = parkingCharge;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	@Override
	public String toString() {
		return "ParkingBean [id=" + id + ", vehicule=" + vehicule + ", parkingCode=" + parkingCode + ", parkingDate="
				+ parkingDate + ", action=" + action + ", parkingCharge=" + parkingCharge + ", remarque=" + remarque
				+ "]";
	}

	
}

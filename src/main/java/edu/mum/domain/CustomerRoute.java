package edu.mum.domain;

import java.io.Serializable;

public class CustomerRoute implements Serializable{
	 private static final long serialVersionUID = 5784L;
	private String firstName;
	private String lastName;
	private String roomNo;
	private double charge;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}

}

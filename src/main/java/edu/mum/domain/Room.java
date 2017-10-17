package edu.mum.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.validation.NullMinNumber;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
//	@NotEmpty
//	private String roomNo;
////	@NotEmpty
//	private String roomType;
////	@NotEmpty
//	private String bedType;
//	
//	private Boolean checked;
//	
////	@NullMinNumber(value=6)
//	private Double roomRate;
	
	
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private RoomInfo roominfo;
	
	public RoomInfo getRoominfo() {
		return roominfo;
	}
	public void setRoominfo(RoomInfo roominfo) {
		this.roominfo = roominfo;
	}
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date arrivalDate;
	
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date departureDate;
	
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
//	@ManyToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	private Customer customer;
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	



//public String getRoomNo() {
//	return roomNo;
//}
//public void setRoomNo(String roomNo) {
//	this.roomNo = roomNo;
//}
//public Double getRoomRate() {
//	return roomRate;
//}
//public void setRoomRate(Double roomRate) {
//	this.roomRate = roomRate;
//}
//public String getRoomType() {
//	return roomType;
//}
//public void setRoomType(String roomType) {
//	this.roomType = roomType;
//}
//public String getBedType() {
//	return bedType;
//}
//public void setBedType(String bedType) {
//	this.bedType = bedType;
//}
//public Boolean getChecked() {
//	return checked;
//}
//public void setChecked(Boolean checked) {
//	this.checked = checked;
//}



}

package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//	@NotEmpty
	private String roomNo;
//	@NotEmpty
	private String roomType;
//	@NotEmpty
	private String bedType;
	
	private Boolean checked;
	
//	@NullMinNumber(value=6)
	private Double roomRate;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Double getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(Double roomRate) {
		this.roomRate = roomRate;
	}

}

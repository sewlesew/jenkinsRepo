package edu.mum.service;

import java.util.Date;
import java.util.List;

import edu.mum.domain.Room;
import edu.mum.domain.RoomInfo;

public interface  RoomInfoService {
	
			
			void save(RoomInfo roominfo);
		  	void update(RoomInfo roominfo);
		  	RoomInfo findOne(long id);
		  	public List<RoomInfo> getRoomsByDate(Date arrivalDate, Date departureDate);
		  public List<RoomInfo> getAllRooms();
}

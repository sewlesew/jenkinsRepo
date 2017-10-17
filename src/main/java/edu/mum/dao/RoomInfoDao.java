package edu.mum.dao;

import java.util.Date;
import java.util.List;

import edu.mum.domain.Room;
import edu.mum.domain.RoomInfo;

public interface RoomInfoDao extends GenericDao<RoomInfo> {

	public List<RoomInfo> getRoomsByDate(Date arrivalDate, Date departureDate);
//	public List<RoomInfo> getAllRooms();
}


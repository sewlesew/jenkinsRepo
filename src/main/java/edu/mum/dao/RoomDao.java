package edu.mum.dao;

import java.util.Date;
import java.util.List;

import edu.mum.domain.Room;

public interface RoomDao extends GenericDao<Room>{
	public List<Room> getRoomsByDate(Date arrivalDate, Date departureDate);
	public List<Room> findAvailableRooms(int val);
}

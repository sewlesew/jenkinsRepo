package edu.mum.service;

import java.util.Date;
import java.util.List;

import edu.mum.domain.Room;

public interface RoomService {
	List<Room> getAllRooms();

  	void save(Room room);
  	void update(Room room);

  	Room findOne(long id);
  	public List<Room> getRoomsByDate(Date arrivalDate, Date departureDate);
  	
  	List<Room> getRoomAvailability(int val);
}

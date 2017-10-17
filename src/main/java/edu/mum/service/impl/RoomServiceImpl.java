package edu.mum.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.RoomDao;
import edu.mum.domain.Room;
import edu.mum.service.RoomService;
@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomService;
	
	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = roomService.findAll();
		return rooms;
	}

	@Override
	public void save(Room room) {
		roomService.save(room);
			}

	@Override
	public Room findOne(long id) {
		return roomService.findOne(id);
	}

	@Override
	public List<Room> getRoomsByDate(Date arrivalDate, Date departureDate) {
		// TODO Auto-generated method stub
		
		return roomService.getRoomsByDate(arrivalDate, departureDate);
	}

	@Override
	public void update(Room room) {

		roomService.update(room);
	}

	@Override
	public List<Room> getRoomAvailability(int val) {

		return roomService.findAvailableRooms(val);
	}

}

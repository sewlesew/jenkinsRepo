package edu.mum.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.RoomDao;

import edu.mum.domain.Room;
@Repository
public class RoomDaoImpl extends GenericDaoImpl<Room> implements RoomDao {

	public RoomDaoImpl() {
		super.setDaoType(Room.class );
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomsByDate(Date arrival, Date departure) {
		
//		Query query=entityManager.createQuery("select r from Room r");
				
		
//		Query query=entityManager.createQuery("select r from Room r where r.arrivalDate"
//				+ ">:departure or r.departureDate<:arrival");
//				
//		List<Room> rooms= (List<Room>)	query.setParameter("arrival", arrival)
//		.setParameter("departure", departure).getResultList();
//		
//		//those whose date are empty are available rooms
//		List<Room> availableRooms= (List<Room>)entityManager.createQuery("select r from Room r where r.arrivalDate=null").getResultList();
//	
//		 rooms.addAll(availableRooms);
//		 return rooms;
		
		
		
		//new query 

		Query query=entityManager.createQuery("select r from Room r, RoomInfo info where "
				+ " r.id=info.id and r.arrivalDature>:departure or r.departureDate<:arrival");
		
		List<Room> roomsFromJoiningTables= (List<Room>)	query.setParameter("arrival", arrival)
				.setParameter("departure", departure).getResultList();
	
		List<Room> checkrooms=(List<Room>)entityManager.createQuery("select r from Room r, RoomInfo info where "
				+ " r.id=info.id ").getResultList();
		
		if(checkrooms.size()==0){
		List<Room> allRooms=entityManager.createQuery("select r from Room r").getResultList();
		return allRooms;
		}
		
		return roomsFromJoiningTables;
		
		
		
//		return (List<Room>)query.getResultList();
	}
	

	@Override
	public List<Room> findAvailableRooms(int availability) {

		Query query =entityManager.createNamedQuery("room.getByAvailability").setParameter("val", availability);
		return (List<Room>) query.getResultList();
		
		
	
	}
}

package edu.mum.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.RoomDao;
import edu.mum.dao.RoomInfoDao;
import edu.mum.domain.Room;
import edu.mum.domain.RoomInfo;
@Repository
public class RoomInfoDaoImpl extends GenericDaoImpl<RoomInfo> implements RoomInfoDao{

	public RoomInfoDaoImpl() {
		super.setDaoType(RoomInfo.class );
		}

	@Override
	@SuppressWarnings("unchecked")
	public List<RoomInfo> getRoomsByDate(Date arrival, Date departure) {
//Query query=entityManager.createQuery("select r from Room r");
				
		
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

		Query query=entityManager.createQuery("select info from Room r, RoomInfo info where "
				+ " r.id=info.id and r.arrivalDate>:departure or r.departureDate<:arrival");
		
		List<RoomInfo> roomsFromJoiningTables= (List<RoomInfo>)	query.setParameter("arrival", arrival)
				.setParameter("departure", departure).getResultList();
	
		
		List<RoomInfo> checkrooms=(List<RoomInfo>)entityManager.createQuery("select info from Room r, RoomInfo info where "
				+ " r.id=info.id ").getResultList();
		
		if(checkrooms.size()==0||checkrooms==null){
		List<RoomInfo> allRooms=entityManager.createQuery("select r from RoomInfo r").getResultList();
		return allRooms;
		}
		
		return roomsFromJoiningTables;
		
	}

	
	
}


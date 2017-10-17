package edu.mum.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.RoomInfoDao;
import edu.mum.domain.RoomInfo;
import edu.mum.service.RoomInfoService;
@Service
@Transactional
public class RoomInfoServiceImpl implements  RoomInfoService {

	
	@Autowired
	RoomInfoDao roomInfoDao;
	@Override
	public void save(RoomInfo roominfo) {
		roomInfoDao.save(roominfo);
		
	}

	@Override
	public void update(RoomInfo roominfo) {
		
		roomInfoDao.update(roominfo);
	}

	@Override
	public RoomInfo findOne(long id) {
		
		return roomInfoDao.findOne(id);
	}

	@Override
	public List<RoomInfo> getRoomsByDate(Date arrivalDate, Date departureDate) {
		
		return roomInfoDao.getRoomsByDate(arrivalDate, departureDate);
	}

	@Override
	public List<RoomInfo> getAllRooms() {
		// TODO Auto-generated method stub
		return roomInfoDao.findAll();
	}
	
	

}

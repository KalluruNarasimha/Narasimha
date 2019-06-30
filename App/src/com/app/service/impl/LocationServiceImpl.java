package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService{
	@Autowired
	private ILocationDao dao;

	public int SaveLocation(Location loc) {
		return dao.SaveLocation(loc);
	}

	public void UpdateLocation(Location loc) {
		dao.UpdateLocation(loc);	
	}

	public void DeleteLocation(int locId) {
		dao.DeleteLocation(locId);
	}

	public Location getLocationById(int locId) {
	
		return dao.getLocationById(locId);
	}

	public List<Location> getAllLocations() {
		return dao.getAllLocations();
	}

	public List<Object[]> getLocTypeAndCount() {
		return dao.getLocTypeAndCount();
	}

}

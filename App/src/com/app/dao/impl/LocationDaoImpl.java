package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
@Repository
public class LocationDaoImpl implements ILocationDao {
@Autowired
private HibernateTemplate ht;
	public int SaveLocation(Location loc) {
		int locId=(Integer)ht.save(loc);
		return locId;
	}

	public void UpdateLocation(Location loc) {
		ht.update(loc);
		
	}

	public void DeleteLocation(int locId) {
		ht.delete(new Location(locId));
		
	}

	public Location getLocationById(int locId) {
		Location loc=ht.get(Location.class, locId);
		return loc;
	}

	public List<Location> getAllLocations() {
      List<Location> locList=ht.loadAll(Location.class);
		return locList;
	}

	public List<Object[]> getLocTypeAndCount() {
		String hql="select locType,Count(locType) from com.app.model.Location group by locType";
		@SuppressWarnings("unchecked")
		List<Object[]> data=ht.find(hql);
		return data;
	}
	

}

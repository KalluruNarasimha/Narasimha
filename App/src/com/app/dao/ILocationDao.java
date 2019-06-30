package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {
      public int SaveLocation(Location loc);
      public void UpdateLocation(Location loc);
      public void DeleteLocation(int locId);
      public Location getLocationById(int locId);
      public List<Location> getAllLocations();
      public List<Object[]> getLocTypeAndCount();
      
}

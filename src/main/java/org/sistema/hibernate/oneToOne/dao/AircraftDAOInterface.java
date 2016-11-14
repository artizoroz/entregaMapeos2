package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.sistema.hibernate.oneToOne.models.Aircraft;

public interface AircraftDAOInterface {
	
	public Aircraft selectById(Long id);
	public List<Aircraft> selectAll ();
	public void insert (Aircraft aircraft);
	public void update (Aircraft aircraft);
	public void delete (Aircraft aircraft);

}

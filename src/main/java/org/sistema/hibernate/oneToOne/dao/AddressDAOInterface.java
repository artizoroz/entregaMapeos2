package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.sistema.hibernate.oneToOne.models.Address;

/**
 * interface for AddressDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface AddressDAOInterface {
	
	public Address selectById(Long id);
	public List<Address> selectAll ();
	public void insert (Address address);
	public void update (Address address);
	public void delete (Address address);

}

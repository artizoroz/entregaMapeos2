/**
 * 
 */
package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToOne.HibernateSession;
import org.sistema.hibernate.oneToOne.models.Address;

/**
 * implementation of AddressDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class AddressDAO implements AddressDAOInterface {

	/* 
	 * selects one Address by Id
	 * @param id
	 * @return Address
	 */
	public Address selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Address address = (Address) session.get(Address.class, id);
	    
	    session.close();
	    return address;
	}

	/*
	 * retrieves all Addresss from db
	 * @return List of Addresss
	 */
	public List<Address> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Address> addresses = session.createQuery("from Address").list();
	    
	    session.close();
	    return addresses;
	}

	/*
	 * inserts a new Address in database
	 * retrieves generated id and sets to Address instance
	 * @param new Address
	 */
	public void insert(Address address) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(address);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	/*
	 * updates Address
	 * @param Address to update
	 */
	public void update(Address address) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(address);
		 
		    session.getTransaction().commit();
		    session.close();
	}

	/*
	 * delete given Address
	 * @param Address to delete
	 */
	public void delete(Address address) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(address);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}

/**
 * 
 */
package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToOne.HibernateSession;
import org.sistema.hibernate.oneToOne.models.Aircraft;

public class AircraftDAO implements AircraftDAOInterface {

	/* 
	 * selects one Aircraft by Id
	 * @param id
	 * @return Aircraft
	 */
	public Aircraft selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Aircraft aircraft = (Aircraft) session.get(Aircraft.class, id);
	    
	    session.close();
	    return aircraft;
	}

	/*
	 * retrieves all Aircrafts from db
	 * @return List of Aircrafts
	 */
	public List<Aircraft> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Aircraft> aircraft = session.createQuery("from Aircrafts").list();
	    
	    session.close();
	    return aircraft;
	}

	/*
	 * inserts a new Aircraft in database
	 * retrieves generated id and sets to Aircraft instance
	 * @param new Aircraft
	 */
	public void insert(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(aircraft);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	/*
	 * updates Aircraft
	 * @param Aircraft to update
	 */
	public void update(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(aircraft);
		 
		    session.getTransaction().commit();
		    session.close();
	}

	/*
	 * delete given Aircraft
	 * @param Aircraft to delete
	 */
	public void delete(Aircraft aircraft) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(aircraft);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}

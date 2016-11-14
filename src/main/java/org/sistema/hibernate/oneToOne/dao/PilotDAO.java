/**
 * 
 */
package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToOne.HibernateSession;
import org.sistema.hibernate.oneToOne.models.Pilot;


public class PilotDAO implements PilotDAOInterface {

	/* 
	 * selects one pilot by Id
	 * @param id
	 * @return Pilot
	 */
	public Pilot selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Pilot pilot = (Pilot) session.get(Pilot.class, id);
	    
	    session.close();
	    return pilot;
	}

	/*
	 * retrieves all pilots from db
	 * @return List of pilots
	 */
	public List<Pilot> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Pilot> pilot = session.createQuery("from Pilot").list();
	    
	    session.close();
	    return pilot;
	}

	/*
	 * inserts a new pilot in database
	 * person must come with the idcar set 
	 * @param new pilot
	 */
	public void insert(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(pilot);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates pilot
	 * @param pilot to update
	 */
	public void update(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(pilot); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}

	/*
	 * delete given pilot
	 * @param pilot to delete
	 */
	public void delete(Pilot pilot) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(pilot);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}

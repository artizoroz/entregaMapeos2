/**
 * 
 */
package org.sistema.hibernate.oneToOne.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToOne.HibernateSession;
import org.sistema.hibernate.oneToOne.models.Person;

/**
 * implementation of personDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class PersonDAO implements PersonDAOInterface {

	/* 
	 * selects one person by Id
	 * @param id
	 * @return Person
	 */
	public Person selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Person person = (Person) session.get(Person.class, id);
	    
	    session.close();
	    return person;
	}

	/*
	 * retrieves all persons from db
	 * @return List of persons
	 */
	public List<Person> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Person> persons = session.createQuery("from Person").list();
	    
	    session.close();
	    return persons;
	}

	/*
	 * inserts a new person in database
	 * person must come with the idcar set 
	 * @param new person
	 */
	public void insert(Person person) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(person);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates person
	 * @param person to update
	 */
	public void update(Person person) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(person); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}

	/*
	 * delete given person
	 * @param person to delete
	 */
	public void delete(Person person) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(person);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}

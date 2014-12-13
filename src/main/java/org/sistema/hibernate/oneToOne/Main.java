package org.sistema.hibernate.oneToOne;

import org.hibernate.Session;
import org.sistema.hibernate.oneToOne.models.Address;
import org.sistema.hibernate.oneToOne.models.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setName("Persona que sera borrada");

		Person person2 = new Person();
		person2.setName("Persona que permanecera");

		Address address1 = new Address();
		address1.setStreet("Calle 1");
		address1.setPostCode("12345");

		Address address2 = new Address();
		address2.setStreet("Calle 2");
		address2.setPostCode("54321");

		person1.setAddress(address1);
		person2.setAddress(address2);

		/*
		 * Esta direccion se agrega para comprobar que las personas tomen el
		 * mismo identificador que las direcciones (ninguna persona debe tener
		 * el mismo id de esta direccion)
		 */

		Address address3 = new Address();
		address3.setStreet("Calle de Prueba de identificadores");
		address3.setPostCode("21345");

		/*
		 * En la primer sesion a la base de datos almacenamos los dos objetos
		 * Persona los objetos Direccion se almacenaran en cascada
		 */

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		sesion.persist(address3);
		sesion.persist(person1);
		sesion.persist(person2);
		sesion.getTransaction().commit();
		sesion.close();

		/*
		 * En la segunda sesion eliminamos el objeto persona1, la direccion1
		 * sera borrada en cascada
		 */

		sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		sesion.delete(person1);
		sesion.getTransaction().commit();
		sesion.close();

	}

}

package org.sistema.hibernate.oneToOne;

import org.sistema.hibernate.oneToOne.dao.AddressDAO;
import org.sistema.hibernate.oneToOne.dao.PersonDAO;
import org.sistema.hibernate.oneToOne.models.Address;
import org.sistema.hibernate.oneToOne.models.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setName("Persona 1");

		Person person2 = new Person();
		person2.setName("Persona 2");

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
		address3.setStreet("Calle 3");
		address3.setPostCode("21345");

		AddressDAO addressDAO = new AddressDAO();
		PersonDAO personDAO = new PersonDAO();
		
		//Se inserta la dirección que tendrá el ID 1
		addressDAO.insert(address3);
		
		//Se insertan las personas con direcciones con el mismo ID, dichas direcciones serán
		//almacenadas en cascada
		personDAO.insert(person1);
		personDAO.insert(person2);
		
		//Se elimina la primera persona, por lo que la dirección que tiene asociada
		//también se eliminará en cascada.
		personDAO.delete(person1);

	}

}

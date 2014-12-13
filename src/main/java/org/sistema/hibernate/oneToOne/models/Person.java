package org.sistema.hibernate.oneToOne.models;

/**
 * Person class.
 * 
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Person {
	private long id;
	private String name;
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

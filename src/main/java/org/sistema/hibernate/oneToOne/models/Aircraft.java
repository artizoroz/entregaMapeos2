package org.sistema.hibernate.oneToOne.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Aircraft {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String model;
	private float autonomy;
	
	@OneToOne(cascade = { CascadeType.ALL, CascadeType.ALL })
	private Pilot pilot;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(float autonomy) {
		this.autonomy = autonomy;
	}
	
	

}

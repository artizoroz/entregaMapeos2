package org.sistema.hibernate.oneToOne;

import org.sistema.hibernate.oneToOne.dao.AircraftDAO;
import org.sistema.hibernate.oneToOne.dao.PilotDAO;
import org.sistema.hibernate.oneToOne.models.Aircraft;
import org.sistema.hibernate.oneToOne.models.Pilot;

public class Main {

	public static void main(String[] args) {
		Pilot pilot1 = new Pilot();
		pilot1.setName("Piloto 1");

		Pilot pilot2 = new Pilot();
		pilot2.setName("Piloto 2");

		Aircraft aircraft1 = new Aircraft();
		aircraft1.setModel("Modelo 1");
		aircraft1.setAutonomy(12345f);

		Aircraft aircraft2 = new Aircraft();
		aircraft2.setModel("Modelo 2");
		aircraft2.setAutonomy(54321f);

		pilot1.setAircraft(aircraft1);
		pilot2.setAircraft(aircraft2);

		/*
		 * Esta direccion se agrega para comprobar que las personas tomen el
		 * mismo identificador que las direcciones (ninguna persona debe tener
		 * el mismo id de esta direccion)
		 */

		Aircraft aircraft3 = new Aircraft();
		aircraft3.setModel("Modelo 3");
		aircraft3.setAutonomy(21345f);

		AircraftDAO aircraftDAO = new AircraftDAO();
		PilotDAO pilotDAO = new PilotDAO();
		
		//Se inserta la dirección que tendrá el ID 1
		aircraftDAO.insert(aircraft3);
		
		//Se insertan las personas con direcciones con el mismo ID, dichas direcciones serán
		//almacenadas en cascada
		pilotDAO.insert(pilot1);
		pilotDAO.insert(pilot2);
		
		//Se elimina la primera persona, por lo que la dirección que tiene asociada
		//también se eliminará en cascada.
		pilotDAO.delete(pilot1);

	}

}

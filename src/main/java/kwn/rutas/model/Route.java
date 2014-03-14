package main.java.kwn.rutas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * This class represents the Route table.
 * @author David Callay
 * @version 1.0.0
 */
@Entity
@Table
public class Route {

	/**
	 * Primary Key and name route.
	 */
	@Id
	@Size(max = 4)
	private String name;

	/**
	 * Number of clients in the route
	 */
	private int clients;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClients() {
		return clients;
	}

	public void setClients(int clients) {
		this.clients = clients;
	}
	
}

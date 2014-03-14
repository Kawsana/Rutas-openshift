package main.java.kwn.rutas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	/**
	 * Relationship with client entity.
	 */
	@OneToMany(mappedBy="route", fetch=FetchType.EAGER)
	private List<Client> clientList;
	
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

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	
}

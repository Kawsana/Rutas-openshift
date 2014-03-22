package main.java.kwn.rutas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents the Client table.
 * @author David Callay
 * @version 1.0.0
 */
@Entity
@Table
public class Client {

	/**
	 * Primary Key and id client.
	 */
	@Id
	@Size(max = 10)
	private String id;

	/**
	 * Foreign Key for route table.
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name="route")
	private Route route;
	
	/**
	 * Define if the client have or not an exhibitor.
	 */
	private boolean Exhibitor;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public boolean isExhibitor() {
		return Exhibitor;
	}

	public void setExhibitor(boolean exhibitor) {
		Exhibitor = exhibitor;
	}
	
}

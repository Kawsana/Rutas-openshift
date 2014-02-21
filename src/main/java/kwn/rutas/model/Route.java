package main.java.kwn.rutas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * This class represents the route table.
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

package main.java.kwn.rutas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}

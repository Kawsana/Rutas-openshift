package main.java.kwn.rutas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@SequenceGenerator(name = "seq_route_gen", sequenceName = "seq_route", initialValue = 1, allocationSize = 1)
public class Route {

	@Id
	@GeneratedValue(generator = "seq_route_gen", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	@Size(max = 4)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

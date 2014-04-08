package main.java.kwn.rutas.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.SystemVariables;

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
	 * Client birthday
	 */
	private Calendar DateOfBirth;
	
	/**
	 * Define if the client have or not an exhibitor.
	 */
	private boolean Exhibitor;
	
	/**
	 * Used to format the dateOfBirth property.
	 */
	public static SimpleDateFormat dateFormat = new SimpleDateFormat(SystemVariables.DATE_FORMAT);
	
	/**
	 * Format the dateOfBirth property/value based on the simpleDateFormat object (dateFormat).
	 * @return Date formatted
	 */
	public String getDateFormatted() {
		if(DateOfBirth != null)
			return dateFormat.format(DateOfBirth.getTime());
		else
			return Constants.EMPTY_STRING;
	}	
	
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

	public Calendar getDateOfBirth() {
		return DateOfBirth;
	}
	
	public void setDateOfBirth(Calendar dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
}

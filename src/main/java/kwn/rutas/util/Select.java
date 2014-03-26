package main.java.kwn.rutas.util;

/**
 * Generic class to show value and label data on selectOneMenu primefaces component.
 * @author David Callay
 * @version 1.0.0
 */
public class Select {
	
	/**
	 * Attribute used to show the label of the object.
	 */
	private Object label;
	
	/**
	 * Attribute used to show the value of the object.
	 */
	private Object value;

	/**
	 * Constructor method to create new objects with label and value attributes.
	 * @param label
	 * @param value
	 */
	public Select(Object label, Object value) {
		this.label = label;
		this.value = value;
	}
	
	public Object getLabel() {
		return label;
	}
	public Object getValue() {
		return value;
	}
	
}

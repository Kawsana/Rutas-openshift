package main.java.kwn.rutas.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Base class for beans.
 * It handles globals variables for JPA querys.
 * @author David Callay
 * @version 1.0.0
 */
public class BaseBean {
	
	/**
	 * Global persistence context instance.
	 * Click for more info {@link http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManager.html}
	 */
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Global Query object to just use it in queries.
	 */
	Query query = null;
}

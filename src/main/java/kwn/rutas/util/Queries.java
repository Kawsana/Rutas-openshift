package main.java.kwn.rutas.util;

/**
 * Static class that storages java database queries used in bean classes.
 * @author David Callay
 * @version 1.0.0
 */
public final class Queries {
	
	/**
	 * Select all routes.
	 */
	public static final String GET_ROUTES = "select r from Route r";
	
	/**
	 * Select the clients that belong a route given.
	 */
	public static final String GET_CLIENTS_BY_ROUTE = "select c from Client c where c.route.name = ?1";
	
	/**
	 * Update the client number in the route table.
	 */
	public static final String UPDATE_CLIENTS_IN_ROUTE = "update Route r set clients = ?1 where r.name = ?2";
}

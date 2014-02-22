package main.java.kwn.rutas.services;

import java.util.Collection;

import javax.ejb.Local;

import main.java.kwn.rutas.model.Route;

/**
 * Local interface for Route EJB
 * @author David Callay
 * @version 1.0.0
 */
@Local
public interface RouteService {
	
	/**
	 * Save a new route into the database.
	 * @param route	Object to persists into the database.
	 * @return True if the route has been created, false otherwise.
	 */
	boolean saveRoute(Route route);
	
	/**
	 * Get the routes registered in database.
	 * @return Collection of routes.
	 */
	Collection<Route> getRoutes();
}

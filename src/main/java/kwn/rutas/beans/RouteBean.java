package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;
import main.java.kwn.rutas.util.Queries;

/**
 * Implementation bean for route entity (RouteService interface).
 * It handle its JQL queries.
 * @author David Callay
 * @version 1.0.0
 */
@Stateless
public class RouteBean extends BaseBean implements RouteService{
	
	/**
	 * Save a new route into the database if it not exits.
	 * @param route	Object to persists into the database.
	 * @return True if the route has been created, false otherwise.
	 */
	@Override
	public boolean saveRoute(Route route) {
		boolean success;
		if(em.find(Route.class, route.getName()) == null){
			em.persist(route);
			success = true;
		}else {
			success = false;
		}
		return success;
	}
	
	/**
	 * Get the routes registered in database.
	 * @return Collection of routes.
	 */
	@SuppressWarnings("unchecked")
	public Collection<Route> getRoutes(){
		query = em.createQuery(Queries.getRoutes);
		return query.getResultList();
	}
}

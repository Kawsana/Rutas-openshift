package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

/**
 * Implementation bean for route entity (RouteService interface).
 * It handle its JQL queries.
 * @author David Callay
 * @version 1.0.0
 */
@Stateless
public class RouteBean implements RouteService{
	
	/**
	 * Global Query object to just use it in queries.
	 */
	Query query = null;
	
	/**
	 * Global persistence context instance.
	 * Click for more info {@link http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManager.html}
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Save a new route into the database if it not exits.
	 * @param route	Object to persists into the database.
	 */
	@Override
	public void saveRoute(Route route) {
		//TODO: throw message if route exits
		if(em.find(Route.class, route.getName()) == null)
			em.persist(route);
	}
	
	/**
	 * Get the routes registered in database.
	 * @return Collection of routes.
	 */
	@SuppressWarnings("unchecked")
	public Collection<Route> getRoutes(){
		query = em.createQuery("select r from Route r");
		return query.getResultList();
	}
}

package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

@Stateless
public class RouteBean implements RouteService{
	
	Query query = null;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveRoute(Route route) {
		em.persist(route);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Route> getRoutes(){
		query = em.createQuery("select r from Route r");
		return query.getResultList();
	}
}

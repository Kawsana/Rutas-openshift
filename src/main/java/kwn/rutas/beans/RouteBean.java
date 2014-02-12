package main.java.kwn.rutas.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

@Stateless
public class RouteBean implements RouteService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void saveRoute(Route route) {
		em.persist(route);
	}
	
}

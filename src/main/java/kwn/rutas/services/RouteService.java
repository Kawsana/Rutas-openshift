package main.java.kwn.rutas.services;

import java.util.Collection;

import javax.ejb.Local;

import main.java.kwn.rutas.model.Route;

@Local
public interface RouteService {
	
	void saveRoute(Route route);
	
	Collection<Route> getRoutes();
}

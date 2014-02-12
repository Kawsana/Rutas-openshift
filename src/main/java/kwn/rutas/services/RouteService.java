package main.java.kwn.rutas.services;

import javax.ejb.Local;

import main.java.kwn.rutas.model.Route;

@Local
public interface RouteService {
	
	void saveRoute(Route route);
}

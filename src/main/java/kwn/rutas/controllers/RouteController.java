package main.java.kwn.rutas.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

@ManagedBean
public class RouteController {
	
	@EJB
	private RouteService routeService;
	private Route route;

	public RouteController() {
		route = new Route();
	}
	
	public void saveRoute(){
		routeService.saveRoute(route);
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
}

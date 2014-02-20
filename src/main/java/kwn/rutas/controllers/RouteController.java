package main.java.kwn.rutas.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

@ManagedBean
public class RouteController {
	
	@EJB
	private RouteService routeService;
	private Route route;
	private boolean showNoRoutesMessage;

	public RouteController() {
		route = new Route();
	}
	
	@PostConstruct
	public void PostConstruct() {
		if (routeService.getRoutes().isEmpty()){
			showNoRoutesMessage = true;
		}
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

	public boolean isShowNoRoutesMessage() {
		return showNoRoutesMessage;
	}

}

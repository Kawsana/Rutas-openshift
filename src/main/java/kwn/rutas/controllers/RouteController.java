package main.java.kwn.rutas.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;

/**
 * Manage all view request for Route service.
 * @author David Callay
 * @version 1.0.0
 */
@ManagedBean
public class RouteController {
	
	@EJB
	private RouteService routeService;
	private Route route;
	private boolean showNoRoutesMessage;

	/**
	 * Initialize route variable instances.
	 */
	public RouteController() {
		route = new Route();
	}
	
	/**
	 * Set showNoRoutesMessage boolean variable if routes exits.
	 * It is used to display 'No routes' message.
	 */
	@PostConstruct
	public void PostConstruct() {
		if (routeService.getRoutes().isEmpty()){
			showNoRoutesMessage = true;
		}
	}
	
	/**
	 * Save a new route using routeService.
	 * Add a message to FacesContext if the route has been created successfully or not.  
	 */
	public void saveRoute(){
		if(routeService.saveRoute(route)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Ruta creada"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "La ruta que se quiere crear ya existe"));
		}
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

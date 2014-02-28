package main.java.kwn.rutas.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;
import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.Resources;

/**
 * Manage all view request for Route service.
 * @author David Callay
 * @version 1.1.0
 */
@ManagedBean
public class RouteController {
	
	@EJB
	private RouteService routeService;
	private Route route;
	private boolean showNoRoutesMessage;
	private Collection<Route> routeList;

	/**
	 * Initialize route variable instances.
	 */
	public RouteController() {
		route = new Route();
		routeList = new ArrayList<Route>();
	}
	
	/**
	 * Save a new route using routeService.
	 * Add a message to FacesContext if the route has been created successfully or not.
	 * Set null to 'name' property in order to clean the 'txtRouteName' field.
	 */
	public void saveRoute(){
		if(routeService.saveRoute(route)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, Resources.msgRouteCreated));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, Resources.msgRouteNotCreated));
		}
		route.setName(null);
	}

	/**
	 * Get the route label from the summarize message in the carousel component based on the size of the list.
	 * @return 'ruta' string if the list size contains one element or 'rutas' string if the size contains more than one.
	 */
	public String getRouteLabel(){
		if(routeList.size() == Constants.One)
			return Resources.msgRoute;
		else
			return Resources.msgRoutes;
	}
	
	/**
	 * Set showNoRoutesMessage boolean variable if routes exits or false otherwise.
	 * It is used to display 'No routes' message or the routes list if them exist.
	 */
	public boolean isShowNoRoutesMessage() {
		if (routeService.getRoutes().isEmpty()){
			showNoRoutesMessage = true;
		} else {
			showNoRoutesMessage = false;
		}
		return showNoRoutesMessage;
	}

	/**
	 * Retrieves from the database the registered routes, cleaning the list and recovering the data list again.
	 * @return Collection of existing routes.
	 */
	public Collection<Route> getRouteList() {
		routeList.clear();
		routeList = routeService.getRoutes();
		return routeList;
	}
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}

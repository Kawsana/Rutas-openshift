package main.java.kwn.rutas.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.RouteService;
import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.Resources;

/**
 * Manage all view request for Route service.
 * It uses a view scoped in order to not call the get methods in every request.
 * @author David Callay
 * @version 1.0.0
 */
@ManagedBean
@SessionScoped
public class RouteController {
	
	@EJB
	private RouteService routeService;
	private Route route;
	private boolean showNoRoutesMessage;
	private Collection<Route> routeList;
	private Route selectedRoute;

	/**
	 * Initialize route variable instances.
	 */
	public RouteController() {
		route = new Route();
		routeList = new ArrayList<Route>();
	}
	
	/**
	 * Retrieves from the database the registered routes and Set 'showNoRoutesMessage' boolean variable true if routes exits or false otherwise.
	 * It is used to display 'No routes' message or the routes list if them exist.
	 */
	@PostConstruct
	public void loadRoutes() {
		routeList.clear();
		routeList = routeService.getRoutes();
		
		if (routeList.isEmpty()){
			showNoRoutesMessage = true;
		} else {
			showNoRoutesMessage = false;
		}
	}
	
	/**
	 * Save a new route using routeService.
	 * Add a message to FacesContext if the route has been created successfully or not.
	 * Set null to 'name' property in order to clean the 'txtRouteName' field.
	 */
	public void saveRoute(){
		if(routeService.saveRoute(route)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Resources.MSG_ROUTE_CREATED, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Resources.MSG_ROUTE_NOT_CREATED, null));
		}
		route.setName(null); // Clean the 'txtRouteName' field.
		loadRoutes(true); // Update the route list.
	}

	/**
	 * Get the route label from the summarize message in the carousel component based on the size of the list.
	 * @return 'ruta' string if the list size contains one element or 'rutas' string if the size contains more than one.
	 */
	public String getRouteLabel(){
		if(routeList.size() == Constants.ONE)
			return Resources.MSG_ROUTE;
		else
			return Resources.MSG_ROUTES;
	}
	
	public boolean isShowNoRoutesMessage() {
		return showNoRoutesMessage;
	}

	public Collection<Route> getRouteList() {
		return routeList;
	}
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Route getSelectedRoute() {
		return selectedRoute;
	}

	public void setSelectedRoute(Route selectedRoute) {
		this.selectedRoute = selectedRoute;
	}

}

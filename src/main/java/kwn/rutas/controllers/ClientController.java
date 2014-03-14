package main.java.kwn.rutas.controllers;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import main.java.kwn.rutas.model.Client;
import main.java.kwn.rutas.services.ClientService;

/**
 * Manage all view request for Client service.
 * @author David Callay
 * @version 1.0.0
 */
@ManagedBean
public class ClientController {
	
	private boolean showNoClientsMessage;
	private Collection<Client> clientList;
	@EJB
	private ClientService clientService;
	@ManagedProperty(value="#{routeController.selectedRoute.name}")
	private String routeName;

	/**
	 * Initialize client variable instances.
	 */
	public ClientController() {
		clientList = new ArrayList<Client>();
	}
	
	/**
	 * Retrieves from the database the registered clients and Set 'showNoClientsMessage' boolean variable true if clients exits or false otherwise.
	 * It is used to display 'No clients registered for this route' message or the clients list if them exist.
	 */
	@PostConstruct
	public void loadClients() {
		clientList.clear();
		clientList = clientService.getClientsByRoute(routeName);
		
		if (clientList.isEmpty()){
			showNoClientsMessage = true;
		} else {
			showNoClientsMessage = false;
		}
	}
	
	public boolean isShowNoClientsMessage() {
		return showNoClientsMessage;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

}

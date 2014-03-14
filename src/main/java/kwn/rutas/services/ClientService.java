package main.java.kwn.rutas.services;

import java.util.Collection;

import javax.ejb.Local;

import main.java.kwn.rutas.model.Client;

/**
 * Local interface for Client EJB
 * @author David Callay
 * @version 1.0.0
 */
@Local
public interface ClientService {

	/**
	 * Get the clients registered for a route received as a parameter.
	 * @param Name of route to search its clients.
	 * @return Collection of clients
	 */
	public Collection<Client> getClientsByRoute(String id);
}

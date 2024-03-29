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
	
	/**
	 * Save a new client into the database if it not exits and update the client number in the selected route.
	 * @param client object to persists into the database.
	 * @return True if the client has been created, false otherwise.
	 */
	boolean saveClient(Client client);
	
	/**
	 * Verifies if the id (RUC or CI) is valid with the standard Ecuadorian mechanism.
	 * @param id: RUC or CI to validate.
	 * @return 1: If the id is valid.
	 * 		  -1: If the id is invalid.
	 * 		   0: If there is a problem within the method.
	 */
	public int validateId(String id);
}

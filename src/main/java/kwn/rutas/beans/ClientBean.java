package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.Query;

import main.java.kwn.rutas.model.Client;
import main.java.kwn.rutas.services.ClientService;
import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.Queries;

/**
 * Implementation bean for client entity (ClientService interface).
 * It handle its JQL queries.
 * @author David Callay
 * @version 1.0.0
 */
@Stateless
public class ClientBean extends BaseBean implements ClientService{

	/**
	 * Get the clients registered for a route received as a parameter.
	 * @param Name of route to search its clients.
	 * @return Collection of clients
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Client> getClientsByRoute(String id) {
		Query query = em.createQuery(Queries.GET_CLIENTS_BY_ROUTE);
		query.setParameter(Constants.ONE, id);
		return query.getResultList();
	}
	
}

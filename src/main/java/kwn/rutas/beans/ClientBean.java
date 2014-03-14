package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.Query;

import main.java.kwn.rutas.model.Client;
import main.java.kwn.rutas.services.ClientService;
import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.Queries;

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
		Query query = em.createQuery(Queries.getClientsByRoute);
		query.setParameter(Constants.One, id);
		return query.getResultList();
	}
	
}

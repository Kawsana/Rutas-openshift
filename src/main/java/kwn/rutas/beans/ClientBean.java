package main.java.kwn.rutas.beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.kwn.rutas.model.Client;
import main.java.kwn.rutas.services.ClientService;
import main.java.kwn.rutas.util.Constants;

@Stateless
public class ClientBean implements ClientService{

	/**
	 * Global persistence context instance.
	 * Click for more info {@link http://docs.oracle.com/javaee/6/api/javax/persistence/EntityManager.html}
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Get the clients registered for a route received as a parameter.
	 * @param Name of route to search its clients.
	 * @return Collection of clients
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Client> getClientsByRoute(String id) {
		Query query = em.createQuery("select c from Client c where c.id = ?1");
		query.setParameter(Constants.One, id);
		return query.getResultList();
	}
	
}

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
public class ClientBean extends BaseBean implements ClientService {

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
	
	/**
	 * Save a new client into the database if it not exits.
	 * @param client object to persists into the database.
	 * @return True if the client has been created, false otherwise.
	 */
	@Override
	public boolean saveClient(Client client) {
		boolean success;
		if(em.find(Client.class, client.getId()) == null){
			em.persist(client);
			success = true;
		}else {
			success = false;
		}
		return success;
	}
	
	/**
	 * Verifies if the id (RUC or CI) is valid with the standard Ecuadorian mechanism.
	 * @param id RUC or CI to validate.
	 * @return 1: If the id is valid.\n
	 * 		  -1: If the id is invalid.\n
	 * 		   0: If there is a problem within the method.
	 */
	public int validateId(String id) {
		int result = 0;
		// Length validation
		if(id.length() == 13 || id.length() == 10) {
			if(id.length() == 13) {
				result = validateRUC(id);
			}else if(id.length() == 10) {
				result = validateCI(id);
			}
		}else {
			result = -1;
		}
		return result;
	}
	
	/**
	 * Verifies if the RUC sent as parameter is valid with the standard Ecuadorian mechanism.
	 * @param ruc RUC to validate.
	 * @return 1: If the RUC is valid.
	 * 		  -1: If the RUC is invalid.
	 * 		   0: If there is a problem within the method.
	 */
	private int validateRUC(String ruc) {
		int result = 0;
		// Branch validation
		if(ruc.substring(10) != "000") {
			// Check RUC type
			if(Integer.parseInt(ruc.substring(2, 3)) < 6 ) {
				// CI validation
				if(validateCI(ruc.substring(0, 10)) == 1) {
					result = 1;
				}
			} else if (Integer.parseInt(ruc.substring(2, 3)) == 6) {
				// BEGIN - Public RUC validation
				int coe[] = {3,2,7,6,5,4,3,2}, sum = 0;
				for (int i = 0; i < 8; i ++) {
					sum += Integer.parseInt(ruc.substring(i, i + 1)) * coe[i];
				}
				if((11 - (sum % 11)) == Integer.parseInt(ruc.substring(8, 9))) {
					result = 1;
				}
				// END - Public RUC validation
			} else if (Integer.parseInt(ruc.substring(2, 3)) == 9) {
				// BEGIN - Legal RUC validation
				int coe[] = {4,3,2,7,6,5,4,3,2}, sum = 0;
				for (int i = 0; i < 9; i ++) {
					sum += Integer.parseInt(ruc.substring(i, i + 1)) * coe[i];
				}
				if((11 - (sum % 11)) == Integer.parseInt(ruc.substring(9, 10))) {
					result = 1;
				}
				// END - Legal RUC validation
			}
		}
		return result;
	}
	
	/**
	 * Verifies if the CI sent as parameter is valid with the standard Ecuadorian mechanism.
	 * @param ci CI to validate.
	 * @return 1: If the RUC is valid.
	 * 		  -1: If the RUC is invalid.
	 * 		   0: If there is a problem within the method.
	 */
	private int validateCI(String ci) {
		int result = 0;
		// Person validation
		if(Integer.parseInt(ci.substring(2, 3)) < 6) {
			// Province validation
			if(Integer.parseInt(ci.substring(0, 2)) <= 22 && Integer.parseInt(ci.substring(0, 2)) >= 1) {
				// BEGIN - CI validation
				int coe = 0, sum = 0;
				for (int i = 0; i < ci.length() - 1; i ++) {
					if (i % 2 == 0) {
						coe = 2;
					} else {
						coe = 1;
					}
					if(String.valueOf(Integer.parseInt(ci.substring(i, i + 1)) * coe).length() == 2) {
						sum += Integer.parseInt(String.valueOf(Integer.parseInt(ci.substring(i, i + 1)) * coe).substring(0, 1)) + 
							   Integer.parseInt(String.valueOf(Integer.parseInt(ci.substring(i, i + 1)) * coe).substring(1, 2));
					} else {
						sum += Integer.parseInt(ci.substring(i, i + 1)) * coe;
					}
				}
				if((10 - (sum % 10)) == Integer.parseInt(ci.substring(9, 10))) {
					result = 1;
				}
				// END - CI validation
			}
		}
		return result;
	}
}

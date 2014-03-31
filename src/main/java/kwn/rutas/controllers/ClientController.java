package main.java.kwn.rutas.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import main.java.kwn.rutas.model.Client;
import main.java.kwn.rutas.model.Route;
import main.java.kwn.rutas.services.ClientService;
import main.java.kwn.rutas.services.DateService;
import main.java.kwn.rutas.util.Select;

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
	@ManagedProperty(value="#{routeController.selectedRoute}")
	private Route selectedRoute;
	private DateService dateService;
	private Collection<Select> days;
	private Collection<Select> months;
	private Collection<Select> years;
	private int selectedDay = 0, selectedMonth = 0, selectedYear = 0;
	private Client client;

	/**
	 * Initialize client variable instances.
	 */
	public ClientController() {
		clientList = new ArrayList<Client>();
		dateService = new DateService();
		days = dateService.getDays();
		months = dateService.getMonths();
		years = dateService.getYears();
		client = new Client();
	}
	
	/**
	 * Retrieves from the database the registered clients and Set 'showNoClientsMessage' boolean variable true if clients exits or false otherwise.
	 * It is used to display 'No clients registered for this route' message or the clients list if them exist.
	 */
	@PostConstruct
	public void loadClients() {
		clientList.clear();
		clientList = clientService.getClientsByRoute(selectedRoute.getName());
		if (clientList.isEmpty()){
			showNoClientsMessage = true;
		} else {
			showNoClientsMessage = false;
		}
	}
	
	/**
	 * Save a new client using clientService.
	 */
	public void saveClient() {
		Calendar dateOfBirth = new GregorianCalendar(selectedYear, selectedMonth, selectedDay);
		client.setDateOfBirth(dateOfBirth);
		client.setRoute(selectedRoute);
		
		clientService.saveClient(client);
	}
	
	public boolean isShowNoClientsMessage() {
		return showNoClientsMessage;
	}

	public Route getSelectedRoute() {
		return selectedRoute;
	}

	public void setSelectedRoute(Route selectedRoute) {
		this.selectedRoute = selectedRoute;
	}

	public Collection<Select> getDays() {
		return days;
	}

	public Collection<Select> getMonths() {
		return months;
	}

	public Collection<Select> getYears() {
		return years;
	}

	public void setSelectedDay(int selectedDay) {
		this.selectedDay = selectedDay;
	}

	public void setSelectedMonth(int selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}

	public int getSelectedDay() {
		return selectedDay;
	}

	public int getSelectedMonth() {
		return selectedMonth;
	}

	public int getSelectedYear() {
		return selectedYear;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

}

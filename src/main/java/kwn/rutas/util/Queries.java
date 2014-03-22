package main.java.kwn.rutas.util;

public final class Queries {
	
	public static final String GET_ROUTES = "select r from Route r";
	public static final String GET_CLIENTS_BY_ROUTE = "select c from Client c where c.route.name = ?1";
}

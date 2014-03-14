package main.java.kwn.rutas.util;

public final class Queries {
	
	public static String getRoutes = "select r from Route r";
	public static String getClientsByRoute = "select c from Client c where c.route.name = ?1";
}

package main.java.kwn.rutas.controllers;

import javax.faces.bean.ManagedBean;
import main.java.kwn.rutas.util.Constants;

@ManagedBean
public class UtilController {
	
	public int initialSelectValue ()
	{
		return Constants.INITIAL_SELECT_VALUE;
	}
}

package main.java.kwn.rutas.services;

import java.util.ArrayList;
import java.util.Collection;

import main.java.kwn.rutas.util.Constants;
import main.java.kwn.rutas.util.Resources;
import main.java.kwn.rutas.util.Select;
import main.java.kwn.rutas.util.SystemVariables;

/**
 * Handle services related with dates.
 * It is not implement like a Java Bean.
 * @author David Callay
 * @version 1.0.0
 */
public class DateService {
	
	/**
	 * Get the generic number of days of a month.
	 * @return Collection of days in a month.
	 */
	public Collection<Select> getDays() {
		Collection<Select> days = new ArrayList<Select>();
		// The end of days is stored in a static class.
		for(int i = Constants.ONE; i < Constants.DAYS; i ++){
			days.add(new Select(i, i)); 
		}
		return days;
	}
	
	/**
	 * Get the main letters of a month in a year.
	 * @return Collection of months.
	 */
	public Collection<Select> getMonths() {
		Collection<Select> months = new ArrayList<Select>();
		months.add(new Select(Resources.Months.MONTH_1, Constants.ZERO));
		months.add(new Select(Resources.Months.MONTH_2, Constants.ONE));
		months.add(new Select(Resources.Months.MONTH_3, Constants.TWO));
		months.add(new Select(Resources.Months.MONTH_4, Constants.THREE));
		months.add(new Select(Resources.Months.MONTH_5, Constants.FOUR));
		months.add(new Select(Resources.Months.MONTH_6, Constants.FIVE));
		months.add(new Select(Resources.Months.MONTH_7, Constants.SIX));
		months.add(new Select(Resources.Months.MONTH_8, Constants.SEVEN));
		months.add(new Select(Resources.Months.MONTH_9, Constants.EIGHT));
		months.add(new Select(Resources.Months.MONTH_10, Constants.NINE));
		months.add(new Select(Resources.Months.MONTH_11, Constants.TEN));
		months.add(new Select(Resources.Months.MONTH_12, Constants.ELEVEN));
		return months;
	}
	
	/**
	 * Get the years configured in the system for select a year in date field.
	 * @return Collection of years configured.
	 */
	public Collection<Select> getYears() {
		Collection<Select> years = new ArrayList<Select>();
		// The initial and final year are stored in a static class.
		for(int i = SystemVariables.INITIAL_YEAR; i <= SystemVariables.FINAL_YEAR; i ++){
			years.add(new Select(i, i)); 
		}
		return years;
	}
}

package br.com.gft.model;

import java.util.ArrayList;
import java.util.List;

import br.com.gft.enumeration.TimeOfDayType;

public class Order {
	
	private TimeOfDayType timeOfDayType;
	private List<Dish> listDish;
	
	public Order(){
		this.listDish = new ArrayList<>();
	}

	public TimeOfDayType getTimeOfDayType() {
		return timeOfDayType;
	}

	public void setTimeOfDayType(TimeOfDayType timeOfDayType) {
		this.timeOfDayType = timeOfDayType;
	}

	public List<Dish> getListDish() {
		return listDish;
	}

}

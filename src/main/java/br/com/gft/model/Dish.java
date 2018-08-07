package br.com.gft.model;

import br.com.gft.enumeration.DishType;
import br.com.gft.enumeration.TimeOfDayType;

public class Dish implements Comparable<Dish> {
	
	private String description;
	private Boolean repeat;

	private DishType dishType;
	private TimeOfDayType timeOfDayType;
	
	public Dish(String description, Boolean repeat, DishType dishType, TimeOfDayType timeOfDayType){
		this.description = description;
		this.repeat = repeat;
		this.dishType = dishType;
		this.timeOfDayType = timeOfDayType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Boolean isRepeat() {
		return repeat;
	}
	
	public DishType getDishType() {
		return dishType;
	}
	
	public TimeOfDayType getTimeOfDayType() {
		return timeOfDayType;
	}
	
	@Override
	public int compareTo(Dish food) {
		 return this.getDishType().value().compareTo(food.getDishType().value());
	}

}



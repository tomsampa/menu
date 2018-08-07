package br.com.gft.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gft.enumeration.DishType;
import br.com.gft.enumeration.TimeOfDayType;
import br.com.gft.model.Dish;
import br.com.gft.model.Order;
import br.com.gft.repository.DishRepository;

public class DishService {
	
	DishRepository dishRepository;
	
	public DishService() {
		this.dishRepository = new DishRepository();
	}
	
	public void listTimeOfDay(){
	    for (TimeOfDayType timeOfDayType : TimeOfDayType.values()) {
	    	System.out.println(timeOfDayType.value() +" - "+ timeOfDayType.description());
		}
	}
	
	public void printOrder(Order order){
		
		List<Dish> listDish = order.getListDish();
		Collections.sort(listDish);

		System.out.println(order.getTimeOfDayType().description());

		for (Dish dishOrder : listDish) {
			System.out.println(dishOrder.getDescription());
		}
	}
	
	public Dish getDish(DishType dishType, List<Dish> listDish){
		for (Dish dish : listDish) {
			if(dish.getDishType().equals(dishType)){
				return dish;
			}
		}
		
		return null;
	}
	
	public void insertDishInOrder(Order order, Dish dish){
		order.getListDish().add(dish);
	}
	
	public boolean dishIsValid(Order order, Dish dish){
		
		if(!contains(order, dish.getDishType())){
			return true;
		}
		
		if(dish.isRepeat()){
			return true;
		}
		
		return false;
	}
	
	public boolean timeOfDayIsValid(String timeOfDay){
		
		try {
        	
			Integer option = Integer.parseInt(timeOfDay);
        	TimeOfDayType timeOfDayType = TimeOfDayType.byValue(option);
        	
        	if(timeOfDayType != null){
        		return true;
        	}
        	
        	return false;
		
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public boolean dishTypeIsValid(String dish){
		
		try {
        	
			Integer option = Integer.parseInt(dish);
        	DishType dishType = DishType.byValue(option);
        	
        	if(dishType != null){
        		return true;
        	}
        	
        	return false;
		
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public List<Dish> available(Order order){
		
		List<Dish> listDish = new ArrayList<>();
		
		for (Dish dish : dishRepository.loadDish()) {
			if (dish.getTimeOfDayType().equals(order.getTimeOfDayType())) {
				listDish.add(dish);
			}
		}
		
		return listDish;
	}
	
	public boolean contains(Order order, DishType dishType){
		for (Dish dish : order.getListDish()) {
			if(dish.getDishType().equals(dishType))
				return true;
		}
		return false;
	}
	
}

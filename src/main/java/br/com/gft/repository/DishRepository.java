package br.com.gft.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.gft.enumeration.DishType;
import br.com.gft.enumeration.TimeOfDayType;
import br.com.gft.model.Dish;

public class DishRepository {
	
	public List<Dish> loadDish(){
		
		List<Dish> listDish = new ArrayList<>();
		listDish.add(new Dish("eggs", false, DishType.ENTREE, TimeOfDayType.MORNING));
		listDish.add(new Dish("Toast", false, DishType.SIDE, TimeOfDayType.MORNING));
		listDish.add(new Dish("coffee", true, DishType.DRINK, TimeOfDayType.MORNING));
		listDish.add(new Dish("steak", false, DishType.ENTREE, TimeOfDayType.NIGHT));
		listDish.add(new Dish("potato", true, DishType.SIDE, TimeOfDayType.NIGHT));
		listDish.add(new Dish("wine", false, DishType.DRINK, TimeOfDayType.NIGHT));
		listDish.add(new Dish("cake", false, DishType.DESSERT, TimeOfDayType.NIGHT));
		
		return listDish;
	}

}

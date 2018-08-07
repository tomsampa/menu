package br.com.gft;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gft.enumeration.DishType;
import br.com.gft.enumeration.TimeOfDayType;
import br.com.gft.model.Dish;
import br.com.gft.model.Order;
import br.com.gft.service.DishService;

public class DishTest {
	
	DishService dishService = new DishService();
	
	@Test
	public void notAddDishWhenContainedAndNotRepeated() {
		
		Order order = new Order();
		Dish dish = new Dish("eggs", false, DishType.ENTREE, TimeOfDayType.MORNING);
		Dish dish2 = new Dish("eggs", false, DishType.ENTREE, TimeOfDayType.MORNING);
		order.getListDish().add(dish);
		assertTrue(dishService.contains(order, dish2.getDishType()));
	
	}
	
	@Test
	public void addDishWhenContainedAndRepeated() {
		
		Order order = new Order();
		Dish dish = new Dish("potato", true, DishType.SIDE, TimeOfDayType.NIGHT);
		Dish dish2 = new Dish("potato", true, DishType.SIDE, TimeOfDayType.NIGHT);
		order.getListDish().add(dish);
		assertTrue(dishService.contains(order, dish2.getDishType()));
	
	}
	
}

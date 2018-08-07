package br.com.gft.app;

import java.util.List;
import java.util.Scanner;

import br.com.gft.enumeration.DishType;
import br.com.gft.enumeration.TimeOfDayType;
import br.com.gft.model.Dish;
import br.com.gft.model.Order;
import br.com.gft.service.DishService;

public class Application {

	public static void main(String[] args) {

		Order order = new Order();
		DishService dishService = new DishService();
		Scanner scanner = new Scanner(System.in);
		Boolean proceed = Boolean.FALSE;

		do {

			System.out.println("\nSelecione a opção");
			System.out.println("1 - Adicionar prato");
			System.out.println("2 - Imprimir pedido");
			System.out.println("0 - Finalizar programa");
			System.out.print("->");

			String optionSelected = scanner.nextLine();

			if (optionSelected.equals("1")) {

				// TimeOfDay
				if (order.getTimeOfDayType() == null) {

					do {

						System.out.println("\nSelecione um horário");
						dishService.listTimeOfDay();

						System.out.print("->");

						String timeOfDaySelected = scanner.nextLine();
						if (!dishService.timeOfDayIsValid(timeOfDaySelected)) {
							System.out.println("Valor inválido!\n");
							continue;
						}

						TimeOfDayType timeOfDayType = TimeOfDayType.byValue(Integer.parseInt(timeOfDaySelected));
						order.setTimeOfDayType(timeOfDayType);

						proceed = Boolean.TRUE;

					} while (!proceed);

				}

				do {

					// Available
					System.out.println("\nPratos disponíveis");
					List<Dish> listAvailableDishes = dishService.available(order);
					for (Dish dish : listAvailableDishes) {
						System.out.println(dish.getDishType().value() + " - " + dish.getDescription());
					}

					System.out.println("\nDigite a opção do prato desejado");
					System.out.print("->");
					String dishSelected = scanner.nextLine();

					if (!dishService.dishTypeIsValid(dishSelected)) {
						System.out.println("Valor inválido!\n");
						continue;
					}

					DishType dishType = DishType.byValue(Integer.parseInt(dishSelected));
					Dish dish = dishService.getDish(dishType, listAvailableDishes);

					if (dishService.contains(order, dishType) && !dish.isRepeat()) {
						System.out.println("Prato já incluído no pedido, não pode ser repetido!");
						proceed = Boolean.TRUE;
						continue;
					}

					dishService.insertDishInOrder(order, dish);

					proceed = Boolean.TRUE;

				} while (!proceed);
				proceed = Boolean.FALSE;
			
			} else if (optionSelected.equals("2")) {

				dishService.printOrder(order);

				proceed = Boolean.FALSE;
			
			} else if (optionSelected.equals("0")) {
				System.out.println("\nBom apetite!");
				scanner.close();
				System.exit(0);
			
			} else {
				System.out.println("Valor inválido!\n");
			}

		} while (!proceed);

	}

}

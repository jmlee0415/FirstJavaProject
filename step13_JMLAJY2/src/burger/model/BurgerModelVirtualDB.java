//database로 간주 
package burger.model;

import java.util.ArrayList;

import burger.model.dto.Burger;
import burger.model.dto.Feelings;
import burger.model.dto.Milkshake;
import burger.model.dto.Sidemenu;
import burger.model.dto.Toppings;

public class BurgerModelVirtualDB {
	// DATA 는 private으로 접근 제한하기
	private static BurgerModelVirtualDB instance = new BurgerModelVirtualDB();
	private ArrayList<Feelings> list = new ArrayList<Feelings>();


	private BurgerModelVirtualDB() {
		list.add(new Feelings("Happy", "Bacon Cheese Burger", new Burger("Bacon Cheese Burger", 10000, "Ozzing & Grilllllssss"),
							 new Toppings("Steak Sauce", 500, "Normal"), new Sidemenu("Regular Fries", 7000, "Fries"),
							 new Milkshake("Vanilla", 5000)));

		list.add(new Feelings("Angry", "Baconburger", new Burger("Baconburger", 9000, "Callllllllllmdown"),
							 new Toppings("Jalapeno peppers", 1000, "premium"), new Sidemenu("Chilly Dog", 10000, "Hot Dog"),
							 new Milkshake("Chocolate", 6800)));

		list.add(new Feelings("Sad", "Hamburger", new Burger("Hamburger", 8000, "What happened to you?"),
							 new Toppings("Grilled Mushrooms", 1000, "premium"), new Sidemenu("Large Fries", 10000, "Fries"),
							 new Milkshake("Oreo", 6800)));
	}



	public static BurgerModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<Feelings> getFeelingsList() {
		return list;
	}
}

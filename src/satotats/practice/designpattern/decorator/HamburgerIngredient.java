package satotats.practice.designpattern.decorator;

import java.util.List;

public abstract class HamburgerIngredient {
	
	protected abstract List<String> collect();
	
	void buildHumberger() {
		List<String> ings = collect();
		System.out.println("Here is special humburger for YOU!");
		ings.stream().forEach(System.out::println);
	}
}

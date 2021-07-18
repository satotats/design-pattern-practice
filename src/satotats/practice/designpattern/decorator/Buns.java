package satotats.practice.designpattern.decorator;

import java.util.LinkedList;
import java.util.List;

public class Buns extends HamburgerIngredient {

	@Override
	protected List<String> collect() {
		List<String> list = new LinkedList<>();
		list.add("（　　　　　　　　）");
		list.add("（　　　　　　　　）");
		return list;
	}
	
}

package satotats.practice.designpattern.template;

import java.util.Arrays;
import java.util.List;

public class ButterChickenCurryChief extends CurryChief {

	@Override
	List<Ingredient> getIngredients() {
		return Arrays.asList(
				new Ingredient("Butter"), 
				new Ingredient("Chicken"), 
				new Ingredient("Carrot"), 
				new Ingredient("Onion"));
	}

	@Override
	String getCurryTitle() {
		return "Butter Chicken Curry";
	}

}

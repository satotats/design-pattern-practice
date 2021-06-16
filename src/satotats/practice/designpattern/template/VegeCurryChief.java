package satotats.practice.designpattern.template;

import java.util.Arrays;
import java.util.List;

public class VegeCurryChief extends CurryChief {

	@Override
	List<Ingredient> getIngredients() {
		return Arrays.asList(
				new Ingredient("Carrot"), 
				new Ingredient("Potato"), 
				new Ingredient("Onion"));
	}

	@Override
	String getCurryTitle() {
		return "Vege Curry";
	}

}

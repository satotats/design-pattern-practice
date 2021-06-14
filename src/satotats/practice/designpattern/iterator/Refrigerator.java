package satotats.practice.designpattern.iterator;

import java.util.List;

public class Refrigerator implements Aggregate<Ingredient> {

	private List<Ingredient> ingredients;
	
	Refrigerator (List<Ingredient> ingredients) { 
		this.ingredients = ingredients;
	}
	
	@Override
	public Iterator<Ingredient> getIterator() {
		return new RefrigeratorIterator(this);
	}

	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}

package satotats.practice.designpattern.template;

import java.util.List;

public abstract class CurryChief {

	abstract List<Ingredient> getIngredients();
	
	abstract String getCurryTitle();
	
	public void cook() {
		List<Ingredient> ingredients = getIngredients();
		String curryTitle = getCurryTitle();
		sing(ingredients, curryTitle);
	}
	
	private void sing(List<Ingredient> ingredients, String curryTitle) {
		System.out.print("♪Cut and fry the ingredients: ");
		
		for (int i = 0; i < ingredients.size(); i++) {
			System.out.print(ingredients.get(i));
			
			if (i == ingredients.size()-1) {
				System.out.println("! ");
			} else if (i == ingredients.size()-2) {
				System.out.print(" and ");
			} else {
				System.out.print(", ");
			}
			
		}
		
		System.out.println("♪This is the \"" + curryTitle + "\", here you are!");
	}
	
}

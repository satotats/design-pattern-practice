package satotats.practice.designpattern.iterator;

import java.util.Arrays;
import java.util.List;

import satotats.practice.designpattern.iterator.type.BellPepper;
import satotats.practice.designpattern.iterator.type.Carrot;
import satotats.practice.designpattern.iterator.type.EggPlant;

public class RefrigeratorClient {

	public static void main(String[] args) {

		Aggregate<Ingredient> refrigerator = new Refrigerator(getIngredients());
		
		Iterator<Ingredient> ite = refrigerator.getIterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

	private static List<Ingredient> getIngredients() {
		return Arrays.asList(
				new Carrot("orange", "good"),
				new EggPlant("purple", "good"),
				new BellPepper("green", "diarrhea"));
	}
}

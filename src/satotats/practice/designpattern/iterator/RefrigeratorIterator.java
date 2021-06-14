package satotats.practice.designpattern.iterator;

public class RefrigeratorIterator implements Iterator<Ingredient> {

	private Refrigerator refrigerator;
	private int index;

	RefrigeratorIterator(Refrigerator refrigerator) {
		this.refrigerator = refrigerator;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() {
		return index < this.refrigerator.getIngredients().size();
	}

	@Override
	public Ingredient next() {
		Ingredient ingredient = this.refrigerator.getIngredients().get(index);
		index++;
		return ingredient;
	}

}

package satotats.practice.designpattern.iterator;

public abstract class Ingredient {
	private String color;
	private String freshness;
	
	protected Ingredient(String color, String freshness) {
		super();
		this.color = color;
		this.freshness = freshness;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [color=" + color + "]" + " [freshness=" + freshness + "]";
	}

}
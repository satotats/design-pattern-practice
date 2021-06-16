package satotats.practice.designpattern.template;

public class Ingredient {
	private String name;
	
	Ingredient(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
package satotats.practice.designpattern.decorator;

public class Bacon extends InsideItem {

	public Bacon(HamburgerIngredient ing) {
		super(ing);
	}

	@Override
	protected String getItemStr() {
		return "～～～～～～～～～";
	}

}

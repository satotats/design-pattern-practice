package satotats.practice.designpattern.decorator;

public class Patty extends InsideItem {

	public Patty(HamburgerIngredient ing) {
		super(ing);
	}

	@Override
	protected String getItemStr() {
		return "　■■■■■■■";
	}
	
}

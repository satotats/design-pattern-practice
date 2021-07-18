package satotats.practice.designpattern.decorator;

public class Onion extends InsideItem {

	public Onion(HamburgerIngredient ing) {
		super(ing);
	}

	@Override
	protected String getItemStr() {
		return  "　（（（○）））";
	}

}

package satotats.practice.designpattern.decorator;

public class McDonald {
	public static void main(String[] args) {
		HamburgerIngredient h =
			new Onion(
				new Bacon(
					new Bacon(
						new Patty(
							new Bacon(
								new Buns()
								)
							)
						)
					)
				);
		h.buildHumberger();
	}
}

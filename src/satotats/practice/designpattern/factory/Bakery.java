package satotats.practice.designpattern.factory;

public abstract class Bakery {

	private int sells;

	Bread sell() {
		Bread bread = bake();
		registerSells(bread.getPrice());
		return bread;
	}

	void registerSells(int price) {
		this.sells += price;
	}

	abstract Bread bake();

	void reportSells() {
		System.out.println(this.getClass().getSimpleName() + " - Total sells are " + sells + ".");
	}
}

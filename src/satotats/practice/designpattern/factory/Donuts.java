package satotats.practice.designpattern.factory;

public class Donuts extends Bread {

	private int sweetness;// %

	Donuts(int price, int sweetness) {
		super(price);
		this.sweetness = sweetness;
	}

	@Override
	public String toString() {
		return "Donuts [sweetness=" + sweetness + ", price=" + price + "]";
	}
}

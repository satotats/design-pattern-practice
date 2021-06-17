package satotats.practice.designpattern.factory;

public class CurryBread extends Bread {

	private String curry;

	CurryBread(int price, String curry) {
		super(price);
		this.curry = curry;
	}

	@Override
	public String toString() {
		return "CurryBread [curry=" + curry + ", price=" + price + "]";
	}

}

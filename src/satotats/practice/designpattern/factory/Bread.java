package satotats.practice.designpattern.factory;

public abstract class Bread {

	protected int price;

	Bread(int price) {
		super();
		this.price = price;
	}

	int getPrice() {
		return price;
	}

}

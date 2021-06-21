package satotats.practice.designpattern.prototype;

import java.util.Random;

public class Apple extends Fruits {

	Apple(String[] colorScale, int sweetness) {
		super(colorScale, sweetness);
	}
	@Override
	protected void ripeMore() {
		this.sweetness += new Random().nextInt(20);
	}
	@Override
	Fruits createClone() {
		Fruits f = null;
		try {
			f = (Fruits) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public String toString() {
		return "Apple [color=" + getColor() + ", sweetness="
				+ sweetness + "]";
	}
}

package satotats.practice.designpattern.adaptor;

public class Water {
	
	private int degree;
	private int amount; // ml

	public Water(int amount, int degree) {
		this.degree = degree;
		this.amount = amount;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Water [degree=" + degree + ", amount=" + amount + "]";
	}
	
}

package satotats.practice.designpattern.prototype;

public abstract class Fruits implements Cloneable {

	Fruits(String[] colorScale, int sweetness) {
		this.colorScale = colorScale;
		this.sweetness = sweetness;
	}

	protected int scaleIndex = 0;
	protected String[] colorScale;
	protected int sweetness;
	
	String getColor() {
		return colorScale[scaleIndex];
	}

	void getRiped() {
		System.out.println("----- 1 month lator -----");
		if (scaleIndex < colorScale.length-1) {
			scaleIndex++;
		}
		ripeMore();
	}
	
	abstract protected void ripeMore();
	
	abstract Fruits createClone();
	
}

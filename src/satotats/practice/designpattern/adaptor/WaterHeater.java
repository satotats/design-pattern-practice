package satotats.practice.designpattern.adaptor;

public class WaterHeater {
	
	public Water pullBoiledWater(int amount) {
		return new Water(amount, 100);
	}
	
}

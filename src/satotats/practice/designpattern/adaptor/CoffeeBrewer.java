package satotats.practice.designpattern.adaptor;

public class CoffeeBrewer extends WaterHeater implements WaterServer {

	private static int DESIRED_WATER_DEGREE = 90;

	@Override
	public Water serve(int amount) {
		Water boiledWater = super.pullBoiledWater(amount);
		return coolDown(boiledWater, DESIRED_WATER_DEGREE);
	}

	private Water coolDown(Water hotWater, int targetDegree) {
		hotWater.setDegree(targetDegree);
		return hotWater;
	}
}

package satotats.practice.designpattern.adaptor;

public class UseWaterServers {
	public static void main(String[] args) {
		WaterServer server1 = new CoffeeBrewer();
		
		System.out.println("Give me boiling water to brew coffie...");
		Water water = server1.serve(180);
		System.out.println("Granted: " + water);
	}
}

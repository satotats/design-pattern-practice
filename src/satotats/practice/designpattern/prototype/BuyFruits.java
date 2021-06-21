package satotats.practice.designpattern.prototype;

public class BuyFruits {
	
	public static void main(String[] args) {
		FantasticFarmer ff = new FantasticFarmer();
		
		Fruits a1 = new Apple(new String[] {"green", "red"}, 10);
		Fruits a2 = new Apple(new String[] {"green"}, 10);
		
		ff.stock("Tsugaru", a1);
		ff.stock("Kiou", a2);
		
		buyAndObserve(ff, "Tsugaru");
		buyAndObserve(ff, "Tsugaru");
		buyAndObserve(ff, "Kiou");
		buyAndObserve(ff, "Kiou");
	}
	
	private static void buyAndObserve(FantasticFarmer ff, String appleKind) {
		Fruits a = ff.sell(appleKind);
		System.out.println("Bought " + appleKind + ": ");
		System.out.println(a);
		a.getRiped();
		System.out.println(a);
		System.out.println();
	}
	
}

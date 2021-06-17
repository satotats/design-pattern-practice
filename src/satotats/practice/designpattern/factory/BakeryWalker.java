package satotats.practice.designpattern.factory;

public class BakeryWalker {
	
	public static void main(String[] args) {
		Bakery[] bs = new Bakery[] { new Meijido(), new LittleMermaid() };
		
		for (Bakery b: bs) {
			
			for (int i = 1; i <= 5; i++) {
				System.out.println(i + ". Bought a bread: " + b.sell());
			}
			b.reportSells();
			System.out.println();
		}

	}
}

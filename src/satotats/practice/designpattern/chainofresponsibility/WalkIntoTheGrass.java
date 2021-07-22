package satotats.practice.designpattern.chainofresponsibility;

public class WalkIntoTheGrass {

	public static void main(String[] args) {
		PartyMember p1 = new Pikachu("ピカチュウ", 50, "しらたま");
		PartyMember p2 = new Metapod("トランセル", 40, "つくだに");
		PartyMember p3 = new Dragonite("カイリュー", 120, "ムーミン");

		p1.setNext(p2).setNext(p3);
		
		WildPokemon[] w = {
				new Magikarp("コイキング", 40),
				new Magikarp("コイキング", 100),
				new Rattata("コラッタ", 60),
				new Tauros("ケンタロス", 100),
				new Miewtwo("ミューツー", 200),
				new Miewtwo("メガミューツー", 300)
		};

		for (int i = 0; i < w.length; i++) {
			System.out.println("野生の " + w[i]+ "が とびだしてきた！");
			p1.battle(w[i]);
			System.out.println();
		}
	}
}

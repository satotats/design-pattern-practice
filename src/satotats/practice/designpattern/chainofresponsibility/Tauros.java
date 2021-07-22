package satotats.practice.designpattern.chainofresponsibility;

/** 和名：ケンタロス */
public class Tauros extends WildPokemon{

	public Tauros(String name, int hp) {
		super(name, hp);
	}

	@Override
	public int attack() {
		System.out.println(this + "の つのでつく！");
		return 65;
	}

}

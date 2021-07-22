package satotats.practice.designpattern.chainofresponsibility;

/** 和名：コラッタ */
public class Rattata extends WildPokemon{

	public Rattata(String name, int hp) {
		super(name, hp);
	}

	@Override
	public int attack() {
		System.err.println(this + "の たいあたり！");
		return 35;
	}

}

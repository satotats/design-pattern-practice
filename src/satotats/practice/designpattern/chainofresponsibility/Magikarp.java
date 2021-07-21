package satotats.practice.designpattern.chainofresponsibility;

/** 和名：コイキング */
public class Magikarp extends WildPokemon{

	public Magikarp(String name, int hp) {
		super(name, hp);
	}

	@Override
	public int attack() {
		System.out.println(this + "の はねる！");
		System.err.println("しかし なにも おこらない");
		return 0;
	}

}

package satotats.practice.designpattern.chainofresponsibility;

/** 和名：ミューツーパイセン */
public class Miewtwo extends WildPokemon{

	public Miewtwo(String name, int hp) {
		super(name, hp);
	}

	@Override
	public int attack() {
		System.out.println(this + "の サイコキネシス！");
		return 90;
	}

}

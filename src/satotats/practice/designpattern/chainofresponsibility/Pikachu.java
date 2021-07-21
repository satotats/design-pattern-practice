package satotats.practice.designpattern.chainofresponsibility;

public class Pikachu extends PartyMember {

	public Pikachu(String name, int hp, String nickName) {
		super(name, hp, nickName);
	}
	
	@Override
	public int attack() {
		System.out.println(this + "の 10まんボルト！");
		return 90;
	}

}

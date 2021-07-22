package satotats.practice.designpattern.chainofresponsibility;

/** 和名：トランセル */
public class Metapod extends PartyMember {

	public Metapod(String name, int hp, String nickName) {
		super(name, hp, nickName);
	}
	
	@Override
	public int attack() {
		System.out.println(this + "の かたくなる！");
		System.err.println("しかし うまく きまらなかった！");
		return 0;
	}

}

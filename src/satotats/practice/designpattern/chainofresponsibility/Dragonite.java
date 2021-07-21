package satotats.practice.designpattern.chainofresponsibility;

/** 和名：カイリュー */
public class Dragonite extends PartyMember {

	public Dragonite(String name, int hp, String nickName) {
		super(name, hp, nickName);
	}

	@Override
	public int attack() {
		System.out.println(this + "の はかいこうせん！");
		return 130;
	}

}

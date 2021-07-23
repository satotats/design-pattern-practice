package satotats.practice.designpattern.chainofresponsibility;

public abstract class PartyMember extends Pokemon {

	private String nickName;

	public PartyMember(String name, int hp, String nickName) {
		super(name, hp);
		this.nickName = nickName;
	}

	private PartyMember next;

	public PartyMember setNext(PartyMember next) {
		this.next = next;
		return next; // to create the chain of .setNext(h).setNext(i)....
	}

	public void battle(Pokemon pokemon) {
		if (hp > 0) {
			// バトル開始時に瀕死状態でなければコール
			System.out.println("いけっ！ " + this + "！");

			while (hp > 0) {
				if /* じぶんのターン */ (pokemon.damaged(this.attack())) {
					System.err.println(pokemon + "との 勝負に勝った！");
					return;
				}

				/* あいてのターン */
				this.damaged(pokemon.attack());
			}
		}

		// 相手がknock-outになる前にhp<=0 -> 負けた場合
		if (this.next != null) {
			next.battle(pokemon);
		} else {
			System.err.println("目の前が まっくらになった！");
			System.out.println("IMPORTANT NOTICE: ポケモンセンターには 計画的に 足をはこびましょう");
		}
	}

	@Override
	public String toString() {
		return nickName != null ? nickName : name;
	}
}

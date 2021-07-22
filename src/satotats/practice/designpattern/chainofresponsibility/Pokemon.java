package satotats.practice.designpattern.chainofresponsibility;

public abstract class Pokemon {
	
	protected String name;
	protected int hp;
	
	public Pokemon(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/** @return damage */
	public abstract int attack();
	
	/** @return isKnockedOut */
	public boolean damaged(int damage) {
		System.out.println(this + "に " + damage + "ダメージ！");
		hp -= damage;
		
		if (hp <= 0) {
			System.err.println(this + "は たおれた！");
			return true;
		}
		return false;
	}
}

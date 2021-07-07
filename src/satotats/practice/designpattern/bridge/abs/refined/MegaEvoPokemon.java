package satotats.practice.designpattern.bridge.abs.refined;

import satotats.practice.designpattern.bridge.abs.Pokemon;

public class MegaEvoPokemon extends Pokemon{

	/** こんなのずるだ！ */
	public void attackTwice() {
		physicalAttack();
		specialAttack();
	}
}

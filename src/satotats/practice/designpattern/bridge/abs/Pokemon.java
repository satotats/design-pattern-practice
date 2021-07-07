package satotats.practice.designpattern.bridge.abs;

import satotats.practice.designpattern.bridge.impl.PokemonImpl;

public class Pokemon {

	private PokemonImpl impl;

	public void inflictStatusEffect() {
		this.impl.statusEffectMove();
	}

	public void physicalAttack() {
		this.impl.physicalAttackMove();
	}

	public void specialAttack() {
		this.impl.specialAttackMove();
	}
}

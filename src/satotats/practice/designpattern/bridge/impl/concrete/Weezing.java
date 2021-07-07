package satotats.practice.designpattern.bridge.impl.concrete;

import satotats.practice.designpattern.bridge.impl.PokemonImpl;

public class Weezing extends PokemonImpl {

	@Override
	public void statusEffectMove() {
		System.out.println("マタドガスの どくどく！");
	}

	@Override
	public void physicalAttackMove() {
		System.out.println("マタドガスの たいあたり！");
	}

	@Override
	public void specialAttackMove() {
		System.out.println("マタドガスの ヘドロばくだん！");
	}

}

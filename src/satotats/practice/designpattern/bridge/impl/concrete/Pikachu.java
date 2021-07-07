package satotats.practice.designpattern.bridge.impl.concrete;

import satotats.practice.designpattern.bridge.impl.PokemonImpl;

public class Pikachu extends PokemonImpl {

	@Override
	public void statusEffectMove() {
		System.out.println("ピカチュウの でんじは！");
	}

	@Override
	public void physicalAttackMove() {
		System.out.println("ピカチュウの ボルテッカー！");
	}

	@Override
	public void specialAttackMove() {
		System.out.println("ピカチュウの 10まんボルト！");
	}

}

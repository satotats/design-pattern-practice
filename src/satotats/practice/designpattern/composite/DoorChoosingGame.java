package satotats.practice.designpattern.composite;

import java.util.Random;

public class DoorChoosingGame {
	public static void main(String[] args) {
		Choice firstChoice = buildChoice();
		System.out.println("Check your luck...");
		firstChoice.open();
	}
	
	private static Choice buildChoice() {
		int seed = (int) (Math.random() * 100);
		System.out.println("Seed number: "+ seed);
		Random random = new Random(seed);
		
		GoodChoice lastChoice = new GoodChoice(random);
		lastChoice.addNextChoice(new Goal());
		lastChoice.addNextChoice(new BadChoice());
		lastChoice.addNextChoice(new BadChoice());
		
		GoodChoice thirdChoice = new GoodChoice(random);
		thirdChoice.addNextChoice(new BadChoice());
		thirdChoice.addNextChoice(lastChoice);
		thirdChoice.addNextChoice(new BadChoice());
		
		GoodChoice secondChoice = new GoodChoice(random);
		secondChoice.addNextChoice(new BadChoice());
		secondChoice.addNextChoice(new BadChoice());
		secondChoice.addNextChoice(thirdChoice);
		
		GoodChoice firstChoice = new GoodChoice(random);
		firstChoice.addNextChoice(secondChoice);
		firstChoice.addNextChoice(new BadChoice());
		firstChoice.addNextChoice(new BadChoice());
		
		return firstChoice;
	}
}

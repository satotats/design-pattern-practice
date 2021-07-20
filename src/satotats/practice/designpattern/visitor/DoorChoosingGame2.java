package satotats.practice.designpattern.visitor;

public class DoorChoosingGame2 {
	public static void main(String[] args) {
		Choice firstChoice = buildChoice();
		System.out.println("Check your luck...");
		
		int seed = (int) (Math.random() * 100000);
		Visitor visitor = new TypicalVisitor(seed);
		firstChoice.accept(visitor);
	}
	
	private static Choice buildChoice() {
		GoodChoice lastChoice = new GoodChoice();
		lastChoice.addNextChoice(new Goal());
		lastChoice.addNextChoice(new BadChoice());
		lastChoice.addNextChoice(new BadChoice());
		lastChoice.addNextChoice(new BadChoice());
		
		GoodChoice thirdChoice = new GoodChoice();
		thirdChoice.addNextChoice(new BadChoice());
		thirdChoice.addNextChoice(lastChoice);
		thirdChoice.addNextChoice(new BadChoice());
		
		GoodChoice secondChoice = new GoodChoice();
		secondChoice.addNextChoice(new BadChoice());
		secondChoice.addNextChoice(thirdChoice);
		
		GoodChoice firstChoice = new GoodChoice();
		firstChoice.addNextChoice(secondChoice);
		firstChoice.addNextChoice(new BadChoice());
		
		return firstChoice;
	}
}

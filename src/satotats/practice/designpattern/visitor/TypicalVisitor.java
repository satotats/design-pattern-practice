package satotats.practice.designpattern.visitor;

import java.util.List;
import java.util.Random;

public class TypicalVisitor extends Visitor {

	private Random random;
	private int luckeyNo;
	
	public TypicalVisitor(int seed) {
		this.random = new Random(seed);
		this.luckeyNo = seed;
	}
	
	@Override
	void visit(GoodChoice gc) {
		if (gc.getDepth() > 1) {
			System.out.println("*** Success...!! ***");
		}
		
		List<Choice> nextChoices = gc.getNextChoices();
		System.out.println("Try " + gc.getDepth() + " - success rate: 1 / " + nextChoices.size());
		
		int nextChoice = this.random.nextInt(nextChoices.size());
		Choice choice = nextChoices.get(nextChoice);
		choice.accept(this);
	}

	@Override
	void visit(BadChoice bc) {
		System.out.println("Failue!!!");
		throw new GameOverException2("GAME OVER!!!!");
	}

	@Override
	void visit(Goal g) {
		System.out.println("**************** Game Clear ***************");
		System.out.println("Congratulations!!!!!!");
		System.out.println("Luckey Number - " + luckeyNo);
	}

}

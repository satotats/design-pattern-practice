package satotats.practice.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class GoodChoice extends Choice {

	private List<Choice> nextChoices = new ArrayList<>();
	private int depth;

	GoodChoice() {
		this.depth = 1;
	}

	void addNextChoice(Choice choice) {
		if (choice instanceof GoodChoice) {
			incrementDepth((GoodChoice) choice);
		}
		this.nextChoices.add(choice);
	}

	public int getDepth() {
		return this.depth;
	}

	
	public List<Choice> getNextChoices() {
		return this.nextChoices;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	private static void incrementDepth(GoodChoice choice) {
		choice.depth++;
		choice.nextChoices.stream()
			.filter(c -> c instanceof GoodChoice)
			.map(c ->  (GoodChoice) c)
			.forEach(GoodChoice::incrementDepth);
	}

}

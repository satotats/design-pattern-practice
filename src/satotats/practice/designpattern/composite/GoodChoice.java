package satotats.practice.designpattern.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoodChoice extends Choice {

	private List<Choice> nextChoices = new ArrayList<>();
	private Random random;
	private int seq; 

	GoodChoice(Random random) {
		this.random = random;
		this.seq = 1; 
	}

	@Override
	protected void open() {
		if (seq > 1) {
			System.out.println("*** Success...!! ***");
		}
		
		System.out.println("Try " + seq + " - success rate: 1 / " + nextChoices.size());
		
		int nextChoice = this.random.nextInt(nextChoices.size());
		Choice choice = this.nextChoices.get(nextChoice);
		choice.open();
	}

	void addNextChoice(Choice choice) {
		if (choice instanceof GoodChoice) {
			incrementSeq((GoodChoice) choice);			
		}
		nextChoices.add(choice);
	}
	
	private static void incrementSeq(GoodChoice choice) {
		choice.seq++;
		choice.nextChoices.stream()
			.filter(c -> c instanceof GoodChoice)
			.map(c ->  (GoodChoice) c)
			.forEach(GoodChoice::incrementSeq);
	}

}

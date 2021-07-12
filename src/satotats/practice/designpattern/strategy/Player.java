package satotats.practice.designpattern.strategy;

public class Player {

	private Strategy strategy;

	Player(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	void chooseSticks(int[] sticks) {
		this.strategy.chooseSticks(sticks);
	}
}

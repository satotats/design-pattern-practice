package satotats.practice.designpattern.strategy;

public class Player {

	private Strategy strategy;

	Player(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	void deleteSticks(int[] sticks) {
		this.strategy.deleteSticks(sticks);
	}
}

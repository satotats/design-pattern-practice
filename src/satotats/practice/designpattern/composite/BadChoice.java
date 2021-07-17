package satotats.practice.designpattern.composite;

public class BadChoice extends Choice{

	@Override
	protected void open() {
		System.out.println("Failue!!!");
		throw new GameOverException("Game over!!!!");
	}

}

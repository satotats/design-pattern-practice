package satotats.practice.designpattern.composite;

public class Goal extends Choice{

	@Override
	protected void open() {
		System.out.println("**************** Game Clear ***************");
		System.out.println("Congratulations!!!!!!");
	}

}

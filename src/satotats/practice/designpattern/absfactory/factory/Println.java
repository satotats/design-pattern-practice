package satotats.practice.designpattern.absfactory.factory;

public abstract class Println extends Code {
	
	protected String text;

	public Println(String text) {
		super();
		this.text = text;
	}
	
}

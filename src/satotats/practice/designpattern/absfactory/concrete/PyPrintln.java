package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Println;

public class PyPrintln extends Println {

	public PyPrintln(String text) {
		super(text);
	}

	@Override
	public String buildCode() {
		return "print(\"" + text + "\")\n";
	}
	
}

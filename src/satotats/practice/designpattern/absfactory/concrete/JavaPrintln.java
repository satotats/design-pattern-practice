package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Println;

public class JavaPrintln extends Println {

	public JavaPrintln(String text) {
		super(text);
	}

	@Override
	public String buildCode() {
		return "System.out.println(\"" + text + "\");\n";
	}
	
}

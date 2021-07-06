package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Factory;
import satotats.practice.designpattern.absfactory.factory.Loop;
import satotats.practice.designpattern.absfactory.factory.Println;
import satotats.practice.designpattern.absfactory.factory.Program;

public class JavaFactory extends Factory {

	@Override
	public Println createPrintln(String text) {
		return new JavaPrintln(text);
	}

	@Override
	public Loop createLoop(int loopCnt) {
		return new JavaLoop(loopCnt);
	}

	@Override
	public Program createProgram(String fileName) {
		return new JavaProgram(fileName);
	}

}

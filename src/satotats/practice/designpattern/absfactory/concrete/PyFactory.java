package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Factory;
import satotats.practice.designpattern.absfactory.factory.Loop;
import satotats.practice.designpattern.absfactory.factory.Println;
import satotats.practice.designpattern.absfactory.factory.Program;

public class PyFactory extends Factory {

	@Override
	public Println createPrintln(String text) {
		return new PyPrintln(text);
	}

	@Override
	public Loop createLoop(int loopCnt) {
		return new PyLoop(loopCnt);
	}

	@Override
	public Program createProgram(String fileName) {
		return new PyProgram(fileName);
	}

}

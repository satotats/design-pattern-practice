package satotats.practice.designpattern.absfactory;

import satotats.practice.designpattern.absfactory.factory.Factory;
import satotats.practice.designpattern.absfactory.factory.Loop;
import satotats.practice.designpattern.absfactory.factory.Println;
import satotats.practice.designpattern.absfactory.factory.Program;

public class Main {
	
	/** 
	 * @param args Specify the FQCN corresponding to the programming language you want to generate
	 * <br> * use the 1st argument
	 * <br> Java: satotats.practice.designpattern.absfactory.concrete.JavaFactory
	 * <br> Python: satotats.practice.designpattern.absfactory.concrete.PyFactory
	 */
	public static void main(String[] args) {
		Factory f = Factory.getFactory(args[0]);
		generate(f);
	}
	
	private static void generate(Factory f) {
		Println title = f.createPrintln("**** JOJO'S BIZARRE ADVENTURE ***");
		
		Println opening = f.createPrintln("♪♪♪♪ 愉快な音楽 ♪♪♪♪");
		
		Println spCall = f.createPrintln("Star Platinum!");
		Println spRush = f.createPrintln("ｵﾗ");
		
		Println cdCall = f.createPrintln("Crazy Diamond!");
		Println cdRush = f.createPrintln("ﾄﾞﾗ");
		
		Println tbc= f.createPrintln("To be continued...");
		
		Println coolLine = f.createPrintln("やれやれだぜ。");
		
		Loop stories = f.createLoop(3);
		
		stories.add(opening);
		
		stories.add(spCall);
		Loop spRushTime = f.createLoop(20);
		spRushTime.add(spRush);
		stories.add(spRushTime);
		
		stories.add(cdCall);
		Loop cdRushTime = f.createLoop(100);
		cdRushTime.add(cdRush);
		stories.add(cdRushTime);
		
		stories.add(tbc);
		
		
		Program p = f.createProgram("JojoRushes");
		p.add(title);
		p.add(stories);
		p.add(coolLine);
		
		p.output();
	}
}

package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Loop;
import satotats.practice.designpattern.absfactory.factory.VariableGenerator;

public class JavaLoop extends Loop {

	public JavaLoop(int loopCnt) {
		super(loopCnt);
	}

	@Override
	public String buildCode() {
		StringBuilder sb = new StringBuilder();
		
		String var = VariableGenerator.generate(depth);
		sb.append("for (int " + var + " = 0; " + var + " < " + loopCnt + "; " + var + "++) {\n");
		items.forEach(item -> sb.append(item.buildCode()));
		sb.append("}\n");
		
		return sb.toString();
	}

}

package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Loop;
import satotats.practice.designpattern.absfactory.factory.VariableGenerator;

public class PyLoop extends Loop {

	public PyLoop(int loopCnt) {
		super(loopCnt);
	}

	@Override
	public String buildCode() {
		StringBuilder sb = new StringBuilder();
		String var = VariableGenerator.generate(depth);
		
		sb.append("for " + var + " in range(" + loopCnt + "):\n");
		items.forEach(item -> {
			sb.append(getBaseIndent());
			sb.append("\t");
			sb.append(item.buildCode());
		});
		return sb.toString();
	}
}

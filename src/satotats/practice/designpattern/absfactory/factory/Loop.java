package satotats.practice.designpattern.absfactory.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Loop extends Code {

	protected List<Code> items = new ArrayList<>();
	protected int depth = 0;
	protected int loopCnt;

	public Loop(int loopCnt) {
		super();
		this.loopCnt = loopCnt;
	}

	public void add(Code item) {
		if (item instanceof Loop) {
			addDepth((Loop) item);
		}
		this.items.add(item);
	}

	private void addDepth(Loop loop) {
		loop.depth++;
		loop.items.forEach(item -> {
			if (item instanceof Loop) {
				((Loop) item).addDepth(loop);
			}
		});
	}
	
	protected String getBaseIndent() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= depth; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}
}

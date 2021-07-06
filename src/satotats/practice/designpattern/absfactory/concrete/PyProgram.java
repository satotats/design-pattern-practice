package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Program;

public class PyProgram extends Program {

	public PyProgram(String fileName) {
		super(fileName);
	}

	@Override
	protected String getExtention() {
		return ".py";
	}

	@Override
	protected String makeCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("def main():\n");
		codes.forEach(code -> {
			sb.append("\t");
			sb.append(code.buildCode());
		});
		sb.append("\n");
		sb.append("main()");
		return sb.toString();
	}
}

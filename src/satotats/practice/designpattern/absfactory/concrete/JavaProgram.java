package satotats.practice.designpattern.absfactory.concrete;

import satotats.practice.designpattern.absfactory.factory.Program;

public class JavaProgram extends Program {

	public JavaProgram(String fileName) {
		super(fileName);
	}

	@Override
	protected String getExtention() {
		return ".java";
	}

	@Override
	protected String makeCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("public class ");
		sb.append(fileName);
		sb.append("{\n");
		
		sb.append("public static void main(String[] args) {\n");
		codes.forEach(code -> {
			sb.append(code.buildCode());
		});
		sb.append("}\n");
		
		sb.append("}\n");
		return sb.toString();
	}
}

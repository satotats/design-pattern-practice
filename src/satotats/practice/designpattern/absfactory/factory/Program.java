package satotats.practice.designpattern.absfactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Program {
	
	protected List<Code> codes = new ArrayList<>();
	protected String fileName;
	
	public Program(String fileName) {
		this.fileName = fileName;
	}

	public void add(Code code) {
		codes.add(code);
	}
	
	public void output() {
		try {
			String fileName = this.fileName + this.getExtention(); 
			Writer writer = new FileWriter(fileName);
			writer.write(this.makeCode());
			writer.close();
			System.out.println("The file generated successfully...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String getExtention();
	protected abstract String makeCode();
}

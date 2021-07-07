package satotats.practice.designpattern.absfactory.factory;

public abstract class Factory {

	public static Factory getFactory(String className) {
		Factory factory = null;
		try {
			factory = (Factory) Class.forName(className).getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return factory;
	}

	public abstract Println createPrintln(String text);
	public abstract Loop createLoop(int loopCnt);
	public abstract Program createProgram(String fileName);
}

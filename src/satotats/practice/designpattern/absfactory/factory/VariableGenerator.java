package satotats.practice.designpattern.absfactory.factory;

public class VariableGenerator {

	private static String[] ARPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

	public static String generate(int seed) {
		StringBuilder sb = new StringBuilder();
		return toArphabet(sb, seed);
	}
	
	private static String toArphabet(StringBuilder sb, int i) {
		i = i % ARPHABET.length;
		sb.append(ARPHABET[i]);
		
		if (i / ARPHABET.length < 1) {
			return sb.toString();
		}
		
		return toArphabet(sb, i);
	}
}

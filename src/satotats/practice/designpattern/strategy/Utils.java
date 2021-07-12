package satotats.practice.designpattern.strategy;

public class Utils {

	static int buildNewStickGrp(String[] grpFragments, String newGrpFragment, int index, int originalLength) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < grpFragments.length; i++) {
			if (i != 0) {
				sb.append("0");
			}

			if (i == index) {
				sb.append(newGrpFragment);
			} else {
				sb.append(grpFragments[i]);
			}
		}
		
		while (sb.length() <  originalLength) {
			sb.append("0");
		}
		
		return Integer.parseInt(sb.toString(), 2);
	}
}

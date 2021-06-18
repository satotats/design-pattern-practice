package satotats.practice.designpattern.singleton;

import java.util.Arrays;

public class ClockObserver {
	public static void main(String[] args) {
		MasterClock mc1 = MasterClock.getInstance();
		MasterClock mc2 = MasterClock.getInstance();

		int[] arr = new int[60];
		Arrays.stream(arr)
				.parallel()
				.forEach(n -> {
					if (Math.random() >= 0.1) {
						mc1.spendAMinute();
					} else {
						mc2.spendAMinute();
					}
				});

		System.out.println("mc1");
		mc1.showCurrentTime();
		System.out.println("mc2");
		mc2.showCurrentTime();

		if (mc1 == mc2) {
			System.out.println("********THE SAME********");
		}
	}
}

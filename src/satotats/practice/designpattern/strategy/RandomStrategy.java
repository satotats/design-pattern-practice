package satotats.practice.designpattern.strategy;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RandomStrategy extends Strategy {

	private Random random;

	public RandomStrategy(int seed) {
		this.random = new Random(seed);
	}

	@Override
	public void deleteSticks(int[] stickGrps) {
		log.debug("strategy: random!");
		while (true) {
			int randomIndex = this.random.nextInt(stickGrps.length);

			int stickGrp = stickGrps[randomIndex];
			if (stickGrp == 0) {
				continue;
			}

			String binaryStickGrp = Integer.toBinaryString(stickGrp);
			String[] grpFragments = binaryStickGrp.split("0");
			for (int j = 0; j < grpFragments.length; j++) {
				String grpFragment = grpFragments[j];

				if (grpFragment.isEmpty()) {
					continue;
				}

				String[] sticks = grpFragment.split("");
				int r = this.random.nextInt(sticks.length);
				for (int i = r; i < sticks.length; i++) {
					sticks[i] = "0";
				}

				String newGrpFragment = String.join("", sticks);
				stickGrps[randomIndex] = Utils.buildNewStickGrp(grpFragments, newGrpFragment, j,
						binaryStickGrp.length());
				return;
			}
		}
	}

}

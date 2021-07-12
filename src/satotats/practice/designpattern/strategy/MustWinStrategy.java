package satotats.practice.designpattern.strategy;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MustWinStrategy extends Strategy {

	private Random random;
	
	MustWinStrategy(int seed) {
		super();
		this.random = new Random(seed);
	}

	@Override
	public void deleteSticks(int[] stickGrps) {
		int xorSum = 0;
		int fragmentRemaining = 0;

		for (int i = 0; i < stickGrps.length; i++) {
			int stickGrp = stickGrps[i];

			String[] rowFragments = Integer.toBinaryString(stickGrp).split("0");
			for (int j = 0; j < rowFragments.length; j++) {
				String rowFragment = rowFragments[j];

				if (rowFragment.isEmpty()) {
					continue;
				}

				fragmentRemaining++;
				int sticksNum = rowFragment.split("").length;
				xorSum = xorSum ^ sticksNum;
			}
		}
		
		boolean isLastFragment = fragmentRemaining == 1;
		
		String xnorStr = Integer.toBinaryString(~xorSum);
		int maxBitSize = Integer.toBinaryString(stickGrps.length).length();
		int xnor = Integer.parseInt(xnorStr.substring(xnorStr.length()-maxBitSize), 2);
		if (xnor == 0) {
			randomStrategy(stickGrps, isLastFragment);
		} else {
			log.debug("strategy: make odd");
			selectiveDelete(stickGrps, xnor, isLastFragment);
		}
		return;
	}

	private void randomStrategy(int[] stickGrps, boolean isLastFragment) {
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

				if (isLastFragment) {
					r = sticks.length - 1;
				}

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

	private void selectiveDelete(int[] stickGrps, int deleteFlag, boolean isLastFragment) {
		int[] deleteIndex = new int[2]; // {i, j}
		int maxDeleteStickCnt = 0;

		for (int i = 0; i < stickGrps.length; i++) {
			int stickGrp = stickGrps[i];

			String binaryStickGrp = Integer.toBinaryString(stickGrp);
			String[] grpFragments = binaryStickGrp.split("0");

			for (int j = 0; j < grpFragments.length; j++) {
				String grpFragment = grpFragments[j];

				if (grpFragment.isEmpty()) {
					continue;
				}

				String[] sticks = grpFragment.split("");

				int numOfSticks = sticks.length;
				int sticksAfterDelete = numOfSticks ^ deleteFlag;
				if (numOfSticks < sticksAfterDelete) {
					continue;
				}

				int deleteStickCnt = numOfSticks - sticksAfterDelete;
				if (maxDeleteStickCnt < deleteStickCnt) {
					maxDeleteStickCnt = deleteStickCnt;
					deleteIndex[0] = i;
					deleteIndex[1] = j;
				}
			}
		}

		if (maxDeleteStickCnt == 0) {
			log.debug("Select randomly: since could not apply the strategy...");
			randomStrategy(stickGrps, isLastFragment);
			return;
		}
		
		if (isLastFragment) {
			// 最後のfragmentは、1本残すように選択する
			if (maxDeleteStickCnt > 1) {
				maxDeleteStickCnt = maxDeleteStickCnt - 1;
			} else {
				// もし最後の1本が回ってきたら、おとなしく消す
				maxDeleteStickCnt = 1;
			}
		}

		int stickGrp = stickGrps[deleteIndex[0]];

		String binaryStickGrp = Integer.toBinaryString(stickGrp);
		String[] grpFragments = binaryStickGrp.split("0");
		String[] sticks = grpFragments[deleteIndex[1]].split("");
		
		for (int k = 0; k < maxDeleteStickCnt; k++) {
			sticks[k] = "0";
		}

		String newGrpFragment = String.join("", sticks);
		stickGrps[deleteIndex[0]] = Utils.buildNewStickGrp(grpFragments, newGrpFragment, deleteIndex[1], binaryStickGrp.length());
		return;
	}
}

package satotats.practice.designpattern.strategy;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StickDeleteGame {

	public static void main(String[] args) {
		log.info("////// GAME START //////");
		int[] result = new int[2];

		for (int i = 1; i <= 1000; i++) {
			int numOfRows = 8;
			int seed = (int) (Math.random() * 100) * i;

			Player[] players = {
					new Player(new MustWinStrategy(seed)),
					new Player(new RandomStrategy(seed)),
			};

			log.debug("////// Game {} //////", i);
			int winner = game(numOfRows, players);
			result[winner]++;
		}

		log.info("////// Results //////");
		log.info("p1 - " + result[0] + "win(s)");
		log.info("p2 - " + result[1] + "win(s)");
	}

	static int game(int numOfRows, Player[] players) {
		int[] sticks = buildStickGrps(numOfRows);

		Player p1 = players[0];
		Player p2 = players[1];

		printSticks(sticks);

		int phase = 0;
		while (true) {
			log.debug("------ Phase " + (++phase) + " ------");
			log.debug("****** Player1's turn ******");
			p1.deleteSticks(sticks);
			printSticks(sticks);
			if (isOver(sticks)) {
				log.debug("★★★ Player2 won! ★★★");
				return 1;
			}

			log.debug("****** Player2 turn ******");
			p2.deleteSticks(sticks);
			printSticks(sticks);
			if (isOver(sticks)) {
				log.debug("★★★ Player1 won! ★★★");
				return 0;
			}
		}
	}

	static int[] buildStickGrps(int numOfRows) {
		int[] arr = new int[numOfRows];
		for (int i = 0; i < numOfRows; i++) {
			arr[i] = (int) Math.pow(2, i + 1) - 1;
		}
		return arr;
	}

	static boolean isOver(int[] sticks) {
		return Arrays.stream(sticks).sum() == 0;
	}

	static void printSticks(int[] sticks) {
		for (int i = 0; i < sticks.length; i++) {
			String binary = Integer.toBinaryString(sticks[i]);
			// i+1はその列の棒の本数
			// 文頭の0はtoBinaryStringで消えてしまうので、復活させる
			String formatted = String.format("%" + (i + 1) + "s", binary).replace(" ", "0");
			//全体を右寄せにして表示(※好みの問題)
			log.debug(String.format("%" + sticks.length + "s", formatted));
		}
	}
}

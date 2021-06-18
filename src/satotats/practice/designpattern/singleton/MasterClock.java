package satotats.practice.designpattern.singleton;

/** 
 * @see https://docs.oracle.com/javase/specs/jls/se16/html/jls-12.html#jls-12.4 
 */
public class MasterClock {

	private static MasterClock clock = new MasterClock(0, 0);

	private int hh;
	private int mm;

	private MasterClock(int hh, int mm) {
		this.hh = hh;
		this.mm = mm;
	}

	static MasterClock getInstance() {
		return clock;
	}

	void spendAMinute() {
		mm++;
		if (mm >= 60) {
			mm = 0;
			hh++;
		}
	}

	void showCurrentTime() {
		System.out.println(String.format("%02d", hh) + String.format("%02d", mm));
	}
}

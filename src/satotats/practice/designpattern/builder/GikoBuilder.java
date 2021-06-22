package satotats.practice.designpattern.builder;

public class GikoBuilder extends AABuilder {

	private StringBuilder builder;
	
	GikoBuilder() {
		this.builder = new StringBuilder();
	}

	@Override
	void title() {
		builder.append("*** Giko the Cat ***\n");
	}

	@Override
	void body() {
		builder.append(" ____ ∧ ∧\n");
		builder.append("|＼ /(´～`)＼\n");
		builder.append("|　|￣￣￣￣￣|\n");
		builder.append("|　|＝みかん＝|\n");
		builder.append(" ＼|＿＿＿＿＿|\n");
	}

	@Override
	void reference() {
		builder.append("See: https://ja.wikipedia.org/wiki/%E3%82%A2%E3%82%B9%E3%82%AD%E3%83%BC%E3%82%A2%E3%83%BC%E3%83%88#%E3%83%97%E3%83%AD%E3%83%9D%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%8A%E3%83%AB%E3%83%95%E3%82%A9%E3%83%B3%E3%83%88%E3%81%AE%E3%82%82%E3%81%AE\n");
	}

	@Override
	String getResult() {
		return builder.toString();
	}

	
}

package satotats.practice.designpattern.builder;

public class StalinBuilder extends AABuilder {

	private StringBuilder builder;

	StalinBuilder() {
		this.builder = new StringBuilder();
	}

	@Override
	void title() {
		builder.append("*** Iosif Vissarionovich Stalin (1878-1953) ***\n");
	}

	@Override
	void body() {
		builder.append("　　　 , -.―――--.､\n");
		builder.append("　　 ,ｲ,,i､ﾘ,,リ,,ﾉﾉ,,;;;;;;;;ヽ\n");
		builder.append("　　.i;}'　　　　　　　\"ﾐ;;;;:}\n");
		builder.append("　　|} ,,..､_､　 , _,,,..､ 　|;;;:|\n");
		builder.append("　　|} ,_tｭ,〈 　ﾋ''tｭ_　 i;;;;|\n");
		builder.append("　　|　 ｰ'　|　｀ - 　 　 ﾄ'{\n");
		builder.append("　.｢|　　 ｲ_i _ >､ 　 　 }〉}\n");
		builder.append("　｀{|　_.ﾉ;;/;;/,ゞ;ヽ､ 　.!-'\n");
		builder.append("　　 |　　 　＝'\" 　 　 |\n");
		builder.append("　 　 iﾞ ､_　　ﾞ,,,　 ,,　' {\n");
		builder.append("　　丿＼　￣￣　 _,,-\"ヽ\n");
		builder.append("''\"~ヽ　　＼､_;;,..-\" ＿　,i`ー-\n");
		builder.append("　　 ヽ､oヽ/ ＼　 /o/　 |\n");
	}

	@Override
	void reference() {
		builder.append(
				"See: https://ja.wikipedia.org/wiki/%E3%82%A2%E3%82%B9%E3%82%AD%E3%83%BC%E3%82%A2%E3%83%BC%E3%83%88#%E3%83%97%E3%83%AD%E3%83%9D%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%8A%E3%83%AB%E3%83%95%E3%82%A9%E3%83%B3%E3%83%88%E3%81%AE%E3%82%82%E3%81%AE\n");
	}

	@Override
	String getResult() {
		return builder.toString();
	}

}

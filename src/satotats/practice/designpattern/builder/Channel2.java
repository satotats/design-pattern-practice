package satotats.practice.designpattern.builder;

public class Channel2 {
	public static void main(String[] args) {
		
		AABuilder builder = new GikoBuilder();
		AAArtist artist = new AAArtist(builder);
		
		AABuilder builder2 = new StalinBuilder();
		AAArtist artist2 = new AAArtist(builder2);
		
		artist.inspired();
		System.out.println(builder.getResult());
		
		artist2.inspired();
		System.out.println(builder2.getResult());
	}
}

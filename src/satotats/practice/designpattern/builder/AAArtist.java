package satotats.practice.designpattern.builder;

public class AAArtist {
	
	private AABuilder builder;

	AAArtist(AABuilder builder) {
		this.builder = builder;
	}
	
	void inspired() {
		builder.title();
		builder.body();
		builder.reference();
	}
}

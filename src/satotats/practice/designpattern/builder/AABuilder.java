package satotats.practice.designpattern.builder;

public abstract class AABuilder {

	abstract void title();
	abstract void body();
	abstract void reference();
	abstract String getResult();
}

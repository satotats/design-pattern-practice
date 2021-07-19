package satotats.practice.designpattern.visitor;

public class BadChoice extends Choice {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

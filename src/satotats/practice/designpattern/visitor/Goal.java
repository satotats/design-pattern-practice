package satotats.practice.designpattern.visitor;

public class Goal extends Choice {

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

package satotats.practice.designpattern.visitor;

public abstract class Visitor {

	abstract void visit(GoodChoice gc);
	
	abstract void visit(BadChoice bc);

	abstract void visit(Goal g);
	
}

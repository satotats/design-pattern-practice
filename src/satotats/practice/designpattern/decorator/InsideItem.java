package satotats.practice.designpattern.decorator;

import java.util.List;

public abstract class InsideItem extends HamburgerIngredient{

	protected HamburgerIngredient ing;

	public InsideItem(HamburgerIngredient ing) {
		this.ing = ing;
	}
	
	@Override
	protected List<String> collect() {
		List<String> list = this.ing.collect();
		list.add(1, getItemStr());
		return list;
	}
	
	protected abstract String getItemStr();

}

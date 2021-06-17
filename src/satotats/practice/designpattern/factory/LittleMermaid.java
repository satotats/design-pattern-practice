package satotats.practice.designpattern.factory;

/** 
 * @see https://www.littlemermaid.jp/
 */
public class LittleMermaid extends Bakery {

	@Override
	Bread bake() {
		return new Donuts(100, 50);
	}
	
}

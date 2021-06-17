package satotats.practice.designpattern.factory;

/** 
 * @see https://www.meijido.tokyo/ 
 */
public class Meijido extends Bakery {
	
	@Override
	Bread bake() {
		return new CurryBread(180, "Beef Curry");
	}

}

package satotats.practice.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class FantasticFarmer {

	Map<String, Fruits> inv = new HashMap<>();
	
	void stock(String key, Fruits fruits) {
		inv.put(key, fruits);
	}
	
	Fruits sell(String key) {
		Fruits f = inv.get(key);
		return f.createClone();
	}
}

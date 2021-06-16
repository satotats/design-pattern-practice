package satotats.practice.designpattern.template;

public class CurryRestaurant {
	public static void main(String[] args) {
		CurryChief cf1 = new VegeCurryChief();
		CurryChief cf2 = new ButterChickenCurryChief();
		
		cf1.cook();
		
		System.out.println();
		System.out.println("~~~~~ Coffee break ~~~~");
		System.out.println();
		
		cf2.cook();
	}
}

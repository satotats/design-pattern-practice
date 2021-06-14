package satotats.practice.designpattern.iterator;

public interface Iterator<T> {
	
	/** 
	 * @return true if the next line exists 
	 * */
	boolean hasNext();
	
	T next();
}

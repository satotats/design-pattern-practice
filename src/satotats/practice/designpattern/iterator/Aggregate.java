package satotats.practice.designpattern.iterator;

public interface Aggregate<T> {
	Iterator<T> getIterator();
}

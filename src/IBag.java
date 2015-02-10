
public interface IBag<T> extends IContainer<T>
{
	//Removes all instances of the specified object
	public void remove(T item);
	//returns the amount of times the
	public int getFrequency(T item);
	
}

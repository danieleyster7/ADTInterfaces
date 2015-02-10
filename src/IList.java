
public interface IList<T> extends IContainer<T>
{
	//Adds item to end of List
	public void addEnd(T item);
	//Replaces item at index with passed item
	public void replace(int index, T item);
	public void remove(T item);
	//returns the item at the index
	public T get(int index);

}

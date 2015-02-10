
public interface IContainer<T>
{
	//Adds item to container
	public void add(T item);
	//clears all contents from container
	public void clear();
	//returns true if item is in container
	public boolean contains(T item);
	//displays the contents of container
	public void display();
	//returns the number of items in the container
	public int getLength();
	//returns true if the container was empty
	public boolean isEmpty();
	//removes an unspecified item
	public void remove();
	//puts the contents into a string
	public String toString();
}

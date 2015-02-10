/*************************************
*  Week 1 lab - exercise 2:          *
*   implementing an ArrayList class  *
**************************************/

/**
 * Class implementing an array based list.
 */
public class ArrayBag<T> implements IBag<T>
{
	private static int DEFAULTSIZE = 20;   		//size of the array that stores the bag items
	private int size;
    private T[] bag;             //array to store the bag items
    private int length;             //amount of items in the bag
	
    /**
     * Default constructor. Sets length to 0, initializing the list as an empty
     * list. Default size of array is 20.
     */
    public ArrayBag()
    {
        this(DEFAULTSIZE);
    }
	
    /**
     * Determines whether the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Prints the list elements.
     */
    public void display()
    {
        for (int i = 0; i < length; i++)
        {
            System.out.print(bag[i] + " ");
        }

        System.out.println();
    }

    /**
     * Adds the element x to the end of the list. List length is increased by 1.
     *
     * @param x element to be added to the list
     */
    public void add(T item)
    {
        ensureCapacity();
        bag[length] = item;
        length++;
        
    }

    //Implementation of methods in the lab exercise
    /**
     * Non default constructor. Sets length to 0, initializing the list as an
     * empty list. Size of array is passed as a parameter.
     *
     * @param size size of the array list
     */
    public ArrayBag(int size)
    {
		length = 0;
		this.size = size;
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[size];
		bag = tempBag;
    }

    /**
     * Returns the number of items in the list (accessor method).
     *
     * @return the number of items in the list.
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Returns the size of the list (accessor method).
     *
     * @return the size of the array
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Removes all of the items from the list. After this operation, the length
     * of the list is zero.
     */
    public void clear()
    {
		while(length > 0)
		{
			length--;
			bag[length] = null;
		}
    }

    /**
     * Deletes an item from the list. All occurrences of item in the list will
     * be removed.
     *
     * @param item element to be removed.
     */
    public void remove(T item)
    {
		boolean found = false;
		//Index through array
		for(int i = 0; i < length; i++)
		{
			//If element == item
			if(bag[i].equals(item))
			{
				found = true;
				//Replace the item with item at end
				bag[i] = bag[length - 1];
				length--;
				//Retest the index again since contains new data
				i--;
			}
		}
		if(!found)
			System.out.println("Remove Error: Item not found in List");
    }

    /**
     * Returns the number of occurrences of the given item
     *
     * @param item position in the list of the item to be returned
     * @return number of occurrences
     */
    public int count(T item)
    {
		int count = 0;
		//Index through array
		for(int i = 0; i < length; i++)
		{
			if(bag[i].equals(item))
				count++;
		}
		return count;
    }

	//Returns true if item is in the bag
	public boolean contains(T item) 
	{
		boolean found = false;
		for(int i = 0; i < length; i++)
		{
			if(bag[i].equals(item))
				found = true;
		}
		return found;
	}

	//Removes a random item from bag
	public void remove() 
	{
		length--;
	}

	//Finds the how many of a specified item is in bag
	public int getFrequency(T item) 
	{
		int count = 0;
		for(int i = 0; i < length; i++)
		{
			if(bag[i].equals(item))
				count++;
		}
		return count;
	}
	
	private void ensureCapacity()
	{
		if(length == size)
		{
			T[] temp = (T[]) new Object[size * 2];
			System.arraycopy(bag, 0, temp, 0, length);
			bag = temp;
			size = size * 2;
		}
	}
}
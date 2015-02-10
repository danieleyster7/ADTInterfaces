/*************************************
*  Week 1 lab - exercise 2:          *
*   implementing an ArrayList class  *
**************************************/

/**
 * Class implementing an array based list.
 */
public class ArrayList <T> implements IList<T>
{
	private static int DEFAULTSIZE = 20;   		//size of the array that stores the list items
	private int size;
    private T[] list;             //array to store the list items
    private int length;             //amount of items in the list
	
    /**
     * Default constructor. Sets length to 0, initializing the list as an empty
     * list. Default size of array is 20.
     */
    public ArrayList()
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
            System.out.print(list[i] + " ");
        }

        System.out.println();
    }

    /**
     * Adds the element x to the end of the list. List length is increased by 1.
     *
     * @param x element to be added to the list
     */
    public void add(T x)
    {
    	ensureCapacity();
        list[length] = x;
        length++;
    }

    /**
     * Removes the element at the given location from the list. List length is
     * decreased by 1.
     *
     * @param pos location of the item to be removed
     */
    public void removeAt(int pos)
    {
        for (int i = pos; i < length - 1; i++)
        {
            list[i] = list[i + 1];
        }
        length--;
    }

    //Implementation of methods in the lab exercise
    /**
     * Non default constructor. Sets length to 0, initializing the list as an
     * empty list. Size of array is passed as a parameter.
     *
     * @param size size of the array list
     */
    public ArrayList(int size)
    {
		this.size = size;
		length = 0;
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[size];
		list = tempList;
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
			list[length] = null;
		}
    }

    /**
     * Replaces the item in the list at the position specified by location.
     *
     * @param location location of the element to be replaced
     * @param item value that will replace the value at location
     */
    public void replace(int location, T item)
    {
		if(location < length && location >= 0)
			list[location] = item;
		else
			System.out.println("Replace Error: Index out of array bounds");
    }

    /**
     * Adds an item to the list at the position specified by location.
     *
     * @param location location where item will be added.
     * @param item item to be added to the list.
     */
    public void add(int location, T item)
    {
		ensureCapacity();
		//Shift the entries up 1 index until the location
		for(int i = length; i > location; i--)
			list[i] = list[i - 1];
		//Insert the item
		list[location] = item;
		length++;
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
			//If element == item, shift everything after down 1 index
			if(list[i].equals(item))
			{
				found = true;
				for(int j = i; j < length - 1; j++)
					list[j] = list[j + 1];
				length--;
				//Retest the index again since contains new data
				i--;
			}
		}
		if(!found)
			System.out.println("Remove Error: Item not found in List");
    }

    /**
     * Returns the element at location
     *
     * @param location position in the list of the item to be returned
     * @return element at location
     */
    public T get(int location)
    {
		if(location < length && location >= 0)
			return list[location];
		else
		{
			System.out.println("Get Error: Location out of Array bounds");
			return list[0];
		}
    }

	//Returns true if the item is in the list
	public boolean contains(T item) {
		boolean found = false;
		for(int i = 0; i < length; i++)
		{
			if(list[i].equals(item))
				found = true;
		}
		return found;
	}

	//Removes last item in list
	public void remove() 
	{
		length--;
	}

	//Adds item to end of list
	public void addEnd(T item) 
	{
		ensureCapacity();
		list[length] = item;
		length++;
	}
	
	private void ensureCapacity()
	{
		if(length == size)
		{
			T[] temp = (T[]) new Object[size * 2];
			System.arraycopy(list, 0, temp, 0, length);
			list = temp;
			size = size * 2;
		}
	}
	
	
	/*
     * Checks to see if a the ArrayList contains the passed list
     * calls contains method
     * smaller array list must have same sequence, since generics can't be sorted
     */
    public boolean contains(ArrayList check)
    {
    	int first = 0;
    	return contains(check, first);
    }
    
    /*
     * Checks to see if a the ArrayList contains the passed list
     * If the first index of the passed list lines up with an element,
     * go to finishcheck method
     * otherwise, keep looking until out of elements
     */
    private boolean contains(ArrayList check, int first)
    {
    	if((list.length - first) < check.getLength())
    		return false;
    	if(check.get(0) == list[first])
    		return finishCheck(check, first + 1, 1);
    	else
    		return contains(check, first + 1);
    }
    
    /*
     * Checks to see if the rest of the passed list matches in the array
     */
    private boolean finishCheck(ArrayList check, int first, int checkIndex)
    {
    	if(check.getLength() <= checkIndex)
    		return true;
    	else
    	{
    		if(check.get(checkIndex) == list[first])
    			return finishCheck(check, first + 1, checkIndex + 1);
    		else
    			return false;
    	}
    }
}

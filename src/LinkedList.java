
/**
 * Class implementing a linked list.
 */
public class LinkedList<T> implements IList<T>
{
    private Node pre;
    private Node post;
    private int numOfEntries;

    /**
     * Initializes the list to empty creating a dummy header node.
     */
    public LinkedList()
    {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.previous = pre;
        numOfEntries = 0;
    }

    /**
     * Determines whether the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (numOfEntries == 0);
    }

    /**
     * Prints the list elements.
     */
    public void display()
    {
        Node current = post.previous;
        display(current);
    }
    
    private void display(Node current)
    {
       	System.out.print(current.info + " ");
        current = current.previous;
        if(current.info != null)
    		display(current);
        else
        	System.out.println("");
    }
    

    /**
     * Adds the element x to the beginning of the list.
     *
     * @param x element to be added to the list
     */
    public void add(T item)
    {
    	Node last = post.previous;
    	Node insert = new Node();
    	insert.info = item;
    	insert.next = post;
    	insert.previous = last;
    	post.previous = insert;
    	last.next = insert;
    	numOfEntries++;
    }
    

    /**
     * Deletes an item from the list. Only the first occurrence of the item in
     * the list will be removed.
     *
     * @param x element to be removed.
     */
    public void remove(T item)
    { 
    	Node old = post.previous;

        //Finding the reference to the node before the one to be deleted
        boolean found = false;
        while (old != null && !found)
        {
            if (old.info.equals(item))
                found = true;
            else
                old = old.previous;
        }

        //if x is in the list, remove it.
        if (found)
        {
            Node after = old.next;
            Node before = old.previous;
            after.previous = before;
            before.next = after;
            numOfEntries--;
        }
    }
    
    public T get(int index)
    {
    	Node currentNode = post;
    	int actualIndex = numOfEntries - index;
    	
    	for(int i = 0; i < actualIndex; i++)
	   	{
	   	 	currentNode = currentNode.previous;
	   	}
   	 	
   	 	return currentNode.info;
    }
    
    public String toString()
    {
    	if(isEmpty())
    		return "Empty";
    	Node current = post.previous;
    	String display = "" + current.info;
    	while(current.previous.info != null)
    	{
    		current = current.previous;
    		display += ", " + current.info;
    	}
    	return display;
    }
    
    public int getLength()
    {
    	return numOfEntries;
    }
    
    public void clear()
    {
    	pre = null;
    	post = null;
    	numOfEntries = 0;
    }
    
    
    //(really addbeginning)
    public void addEnd(T item)
    {
    	Node current = post.previous;
    	
    	while(current.info != null)
    		current = current.previous;
    	
    	current.info = item;
    	Node firstNode = new Node();
    	firstNode.next = current;
    	current.previous = firstNode;
    	numOfEntries++;
    }
    
    //replace item at the index
    public void replace(int index, T item)
    {
    	Node currentNode = post;
    	int actualIndex = numOfEntries - index;
    	
    	for(int i = 0; i < actualIndex; i++)
	   	{
	   	 	currentNode = currentNode.previous;
	   	}
    	currentNode.info = item;
    }
    
    //check if contained
    public boolean contains(T item) {
    	Node old = post.previous;

        //Finding the reference to the node before the one to be deleted
        boolean found = false;
        while (old != null && !found)
        {
            if (old.info.equals(item))
                found = true;
            else
                old = old.previous;
        }
		return found;
	}
    
    //Removes last entry
    public void remove() {
		remove(get(numOfEntries - 1));
	}
    
    private class Node
    {

         private T info;   //element stored in this node
         private Node next;  //link to next node
         private Node previous;

         private Node() {}
     }
}

/**
 * Class implementing a linked list.
 */
public class LinkedBag<T> implements IBag<T>
{
    private Node first;  //dummy header node
    private int numOfEntries;

    /**
     * Initializes the list to empty creating a dummy header node.
     */
    public LinkedBag()
    {
        first = null;
        numOfEntries = 0;
    }

    /**
     * Determines whether the list is empty
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    /**
     * Prints the list elements.
     */
    public void display()
    {
        Node current = first;
        display(current);
    }
    
    private void display(Node current)
    {
        if(current != null)
        {
        	System.out.print(current.info + " ");
        	current = current.next;
        	display(current);
        }
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
        Node newNode = new Node(item);
        newNode.next = first;
        
        first = newNode;
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
        boolean found = false;
        Node currentNode;
        currentNode = first;
        
        while(!found && currentNode != null)
        {
        	if(currentNode.info.equals(item))
        	{
        		currentNode.info = first.info;
        		first = first.next;
        		found = true;
        		numOfEntries--;
        	}
        	currentNode = currentNode.next;
        }
        if(!found)
        	System.out.println("Remove Error: Item not found in List");
    }
    
    public int getFrequency(T item)
    {
    	int count = 0;
    	Node currentNode = first;
    	
    	for(int i = 0; i < numOfEntries; i++)
    	{
    		if(currentNode.info.equals(item))
    			count++;
    		currentNode = currentNode.next;
    	}
    	return count;
    }
    
    public String toString()
    {
    	if(isEmpty())
    		return "Empty";
    	Node current = first;
    	String display = "" + current.info;
    	while(current.next != null)
    	{
    		current = current.next;
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
    	first = null;
    	numOfEntries = 0;
    }
    
    //Check if item is in bag
    public boolean contains(T item) 
    {
    	Node currentNode = first;
    	while(currentNode != null)
        {
        	if(currentNode.info.equals(item))
        		return true;
        	currentNode = currentNode.next;
        }
    	return false;
	}

	public void remove() 
	{
		Node current = first;
		for(int i = 1; i < numOfEntries - 1; i++)
			current = current.next;
		current.next = null;
	}
        
    private class Node
    {

         private T info;   //element stored in this node
         private Node next;  //link to next node

            /**
             * Initializes this node setting info to 0 and next to null
             */
         private Node(T dataPortion)
         {
             this(dataPortion, null);
         }
            
         private Node(T dataPortion, Node nextNode)
         {
        	 info = dataPortion;
             next = nextNode;
         }
     }
}
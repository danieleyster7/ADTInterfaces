
public class Test {
	public static void main(String[] args)
	{
		LinkedList<Integer> testList = new LinkedList();
		
		for(int i = 0; i < 10; i++)
			testList.add(i);
		
		testList.display();
		System.out.println(testList.toString());
		
		testList.remove(5);
		
		testList.display();
		
		testList.addEnd(11);
		
		testList.display();
		
		System.out.println("index 3: " + testList.get(3));
		
		System.out.println("" + testList.isEmpty());
		testList.clear();
		System.out.println("" + testList.isEmpty());
	}
}

package edu.mtc.egr283.rb;

public class DLLIteratorDriver {

	public static void main(String[] args) {
		
		DLL<String> dll = new DLL<String>();
		
		dll.addAtHead("head");
		dll.addAtTail("tail");	
		dll.addAtPosition(1, "Third");
		dll.addAtPosition(1, "second");
		dll.addAtPosition(3, "fifth");
		dll.addAtPosition(3, "fourth");
		dll.addAtPosition(5, "sixth");
		
		System.out.println("The size is " + dll.size());
		System.out.println(dll.toString());
		
		DLLIterator<String> itr = new DLLIterator<String>(dll);
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}//end - while loop
		
	}//end - main

}//end - class DLLIteratorDriver

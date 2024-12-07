package edu.mtc.egr283.rb;

public class DLLDriver {

	public static void main(String[] args) {
		
		DLL<String> dll = new DLL<String>();
		
		dll.addAtHead("head");
		dll.addAtTail("tail");
//		System.out.println(dll.toString());
		
		dll.addAtPosition(1, "Third");
		dll.addAtPosition(1, "second");
		dll.addAtPosition(3, "fifth");
		dll.addAtPosition(3, "fourth");
		dll.addAtPosition(5, "sixth");
		
		System.out.println("The Size is " + dll.size());
		System.out.println(dll.toString());
		
		System.out.println("Remove by Position");
		dll.remove(3);
		
		System.out.println("The Size is " + dll.size());
		System.out.println(dll.toString());
		
		System.out.println("Remove by target - fifth");
		dll.remove("fifth");
		
		System.out.println("The Size is " + dll.size());
		System.out.println(dll.toString());
		
		System.out.println("Set Position 1 to first");
		dll.set(1, "first");
		
		System.out.println("The Size is " + dll.size());
		System.out.println(dll.toString());
		
	}//end - main

}//end - Class DLLDriver

package edu.mtc.egr283.rb;

import java.util.Iterator;

public class DLLIterator<E extends Comparable<? super E>> implements Iterator<E>{
	
	private DLL<E> theDLList;
	private DLLNode<E> currentNode;
	
	public DLLIterator(DLL<E> newDLList)
	{
		this.theDLList = newDLList;
		this.currentNode = this.theDLList.getHead();
	}//end - constructor
	
	@Override 
	public boolean hasNext()
	{
		boolean rv = false;
		
		if(this.currentNode.getNext() != this.theDLList.getTail())
		{
			rv = true;
		}//end - if
		
		return rv;
	}//end - hasNext
	
	@Override
	public E next()
	{
		E rv = null;
		
		this.currentNode = this.currentNode.getNext();
		rv = this.currentNode.getNodeData();
		
		return rv;
	}//end - next
	
}//end - DLLIterator<E>

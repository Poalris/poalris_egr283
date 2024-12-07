package edu.mtc.egr283.rb;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> tail;
	private int length;
	
	private static final String COLON_SPACE = ": ";
	private static final String NEW_LINE = "\n";
	
	public DLL()
	{
		this.length = 0;
		this.head = new DLLNode<T>();
		this.tail = new DLLNode<T>();
		this.head.setNext(tail);
		this.tail.setPrev(head);
	}//end - Constructor
	
	public int size()
	{
		return this.length;
	}//end - size
	
	public T get(int position)
	{
		return this.getDataAtPosition(position);
	}//end - get
	
	public void set(int position, T newNodeData)
	{
		(this.find(position)).setNodeData(newNodeData);
	}//end - set
	
	public void addAtHead(T newNodeData)
	{
		this.addAfter(this.getHead(), new DLLNode<T>(newNodeData));
	}//end - addAtHead
	
	public void addAtTail(T newNodeData)
	{
		this.addAfter(this.getTail().getPrev(), new DLLNode<T>(newNodeData));
	}//end - addAtTail
	
	public void addAtPosition(int position, T newNodeData)
	{
		DLLNode<T> cursor = this.getHead();
		DLLNode<T> newNode = new DLLNode<T>(newNodeData);
		
		if(position > 0)
		{
			cursor = this.find(position - 1);
		}//end - if statement
		
		this.addAfter(cursor, newNode);
	}//end - addAtPosition
	
	public T remove(int position)
	{
		DLLNode<T> cursor = this.getHead();
		if(position > 0)
		{
			cursor = this.find(position - 1);
		}//end - if
		
		DLLNode<T> targetNode = cursor.getNext();
		(targetNode.getPrev()).setNext(targetNode.getNext());
		(targetNode.getNext()).setPrev(targetNode.getPrev());
		--this.length;
		
		T rv = targetNode.getNodeData();
		
		targetNode.setPrev(null);
		targetNode.setNodeData(null);
		targetNode.setNext(null);
		
		return rv;
	}//end - remove(int)
	
	public T remove(T target)
	{
		return this.remove(this.findIndex(target));
	}//end - remove(T)
	
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		DLLNode<T> cursor = this.getHead().getNext();
		int index = 0;
		
		while(cursor != this.getTail())
		{
			sb.append(index);
			sb.append(DLL.COLON_SPACE);
			sb.append(cursor.getNodeData().toString());
			sb.append(DLL.NEW_LINE);
			
			cursor = cursor.getNext();
			++index;
		}//end - toString
		
		return sb.toString();
	}//end - toString
	
	protected DLLNode<T> getHead()
	{
		return this.head;
	}//end - getHead
	
	protected DLLNode<T> getTail()
	{
		return this.tail;
	}//end - getTail
	
	private void addAfter(DLLNode<T> currentNode, DLLNode<T> newNode)
	{
		newNode.setNext(currentNode.getNext());
		newNode.setPrev(currentNode);
		currentNode.setNext(newNode);
		(newNode.getNext()).setPrev(newNode);
		++this.length;
	}//end - addAfter
	
	private int findIndex(T targetData)
	{
		DLLNode<T> cursor = this.getHead().getNext();
		int index = 0;
		
		//Continue to loop until we either reach the end of the list
		//or we find the target data
		while((!cursor.equals(this.getTail())) && (!cursor.getNodeData().equals(targetData)))
		{
			cursor = cursor.getNext();
			++index;
		}//end - while loop
		
		//Set index to -1 if we did not find the target data
		if(!cursor.getNodeData().equals(targetData))
		{
			index = -1;
		}//end - if statement
		
		return index;
	}//end - findIndex
	
	private DLLNode<T> find(int position){
		DLLNode<T> cursor = null;
		
		if(position < (this.size()/2))
		{
			cursor = this.getHead().getNext();
			for(int i = 0; i != position; ++i)
			{
				cursor.getNext();
			}//end - for loop
		}else
		{
			cursor = this.getTail().getPrev();
			for(int i = this.size()-1; i != position; --i)
			{
				cursor.getPrev();
			}
		}//end - if statement
		
		return cursor;
	}//end - method find
	
	private T getDataAtPosition(int position)
	{
		return (this.find(position).getNodeData());
	}//end - getDataAtPosition
	
}//end - Class DLL<T>

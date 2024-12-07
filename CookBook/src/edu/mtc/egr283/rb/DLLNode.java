package edu.mtc.egr283.rb;

/**
 * This is the Double linked list node class.
 * The Class has three fields, one for referencing
 * the previous node, one for data payload and one for referencing
 * the next node
 * 
 * @param <E> the data payload class
 */
public class DLLNode<E> {
	
	private DLLNode<E> prev;
	private E nodeData;
	private DLLNode<E> next;
	
	/**
	 * Constructor takes in three parameters
	 * one for the reference of the previous node
	 * one for node data itself
	 * one for the reference of the next node
	 * @param newPrev reference of the previous node in the list
	 * @param newNodeData node data to be stored
	 * @param newNext reference to the next node in the list
	 */
	public DLLNode(DLLNode<E> newPrev, E newNodeData, DLLNode<E> newNext)
	{
		this.setPrev(newPrev);
		this.setNodeData(newNodeData);
		this.setNext(newNext);
	}//end -constructor(DLLNode, E, DLLNode)
	
	/**
	 * Constructor to create a double linked list
	 * node only containing the node data and the 
	 * references to the previous node and the next
	 * nodes are 'null' values.
	 * @param newNodeData
	 */
	public DLLNode(E newNodeData)
	{
		this(null, newNodeData, null);
	}//end - constructor(E)
	
	/**
	 * Default constructor
	 * 
	 * Creates an empty Double Linked list node
	 * containing null values
	 */
	public DLLNode()
	{
		this(null);
	}//end - default 'no-args' constructor
	
	/**
	 * Accessor method to retrieve the 
	 * reference to the previous node in the list
	 * @return reference to the previous node
	 */
	public DLLNode<E> getPrev() 
	{
		return this.prev;
	}
	
	/**
	 * Mutator method to store the reference
	 * to the previous node in the list
	 * @param newPrev reference to be stored
	 */
	public void setPrev(DLLNode<E> newPrev)
	{
		this.prev = newPrev;
	}//end - setPrev
	
	/**
	 * Accessor method to retrieve the node data
	 * @return the stored node data
	 */
	public E getNodeData()
	{
		return this.nodeData;
	}//end - getNodeData
	
	/**
	 * Mutator method to store the new data
	 * @param newNodeData node data to be stored
	 */
	public void setNodeData(E newNodeData)
	{
		this.nodeData = newNodeData;
	}//end - setNodeData
	
	/**
	 * Accessor method to retrieve the reference
	 * to the next node in the list
	 * @return reference to the next node in the list.
	 */
	public DLLNode<E> getNext()
	{
		return this.next;
	}//end - getNext
	
	/**
	 * Mutator method to store the reference to
	 * the next node in the list
	 * @param newNext reference to be stored.
	 */
	public void setNext(DLLNode<E> newNext)
	{
		this.next = newNext;
	}//end - setNext
	
	
}//end - DLLNode<E>

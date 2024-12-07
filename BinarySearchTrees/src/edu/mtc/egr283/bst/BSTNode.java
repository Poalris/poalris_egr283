package edu.mtc.egr283.bst;

public class BSTNode<T extends Comparable<T>> {
	
	private BSTNode<T> leftChild;
	private BSTNode<T> rightChild;
	private T data;
	
	
	/**
	 * Default constructor; the node is set to null for the data, and
	 * has no left or right child
	 */
	public BSTNode()
	{
		this(null);
	}//end - Default 'no-args' construtor
	
	/**
	 * Constructor for the BSTNode; contains data, however there is
	 * assumed to be no child for either of the trees.
	 * @param newData the new data that will be inserted into the node
	 */
	public BSTNode(T newData)
	{
		this(newData, null, null);
	}//end - constructor
	
	/**
	 * Constructor; constructs a BST node with data inserted into
	 * said node and has the potential of containing either a left
	 * or right child within the node.
	 * @param newData the new data that will be inserted into the node.
	 * @param newLeftChild leaf node
	 * @param newRightChild leaf node
	 */
	public BSTNode(T newData, BSTNode<T> newLeftChild, BSTNode<T> newRightChild)
	{
		this.setData(newData);
		this.setLeft(newLeftChild);
		this.setRight(newRightChild);
	}//end - constructor
	
	/**
	 * Grabs the left node of the parent node
	 * @return the left child of the parent node
	 */
	public BSTNode<T> getLeft()
	{
		return this.leftChild;
	}//end - getLeft
	
	/**
	 * Grabs the right node of the parent node
	 * @return the right child of the parent node
	 */
	public BSTNode<T> getRight()
	{
		return this.rightChild;
	}//end - getRight
	
	/**
	 * Grabs the data from the selected node
	 * @return the data from the selected node
	 */
	public T getData()
	{
		return this.data;
	}//end - getData
	
	/**
	 * Mutator method that assigns the left child with a new node.
	 * @param newLeftChild the desired new node to replace the old node.
	 */
	public void setLeft(BSTNode<T> newLeftChild)
	{
		this.leftChild = newLeftChild;
	}//end - setLeft
	
	/**
	 * Mutator method that assigns the right child with a new node.
	 * @param newRightChild the desired new node to replace the old node.
	 */
	public void setRight(BSTNode<T> newRightChild)
	{
		this.rightChild = newRightChild;
	}//end - setRight
	
	/**
	 * mutator method that replaces the data within a child with
	 * the desired new data.
	 * @param newData
	 */
	public void setData(T newData)
	{
		this.data = newData;
	}//end - setData
	
	/**
	 * Standard compareTo method, but taking the current node
	 * and comparing it to the other node in question.
	 * @param compareItem the other node that must be placed into the system in order for
	 * 		the method to give back results.
	 * @return an int depending on how the item compares(-1 or less , 0 if equal, 1 or greater)
	 */
	public int compareTo(BSTNode<T> compareItem)
	{
		return this.getData().compareTo(compareItem.getData());
	}//end - compareTo
	

	/**
	 * An Override of the standard equals method
	 * takes the node's data, and compares it 
	 * to the desired node's data.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean rv = false;
		
		if((obj != null) && (obj instanceof BSTNode<?>))
		{
			BSTNode<?> bstn = (BSTNode<?>)obj;
			if(this.getData().equals(bstn.getData()))
			{
				rv = true;
			}//end - NESTED if
		}//end - OUTER if
		
		return rv;
	}//end - equals
	
	/**
	 * Usual toString method; displays the data that is inside of the node
	 * in a readable format
	 * @return the toString of the data
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.getData() == null)
		{
			sb.append("NO DATA -- NULL");
		}else
		{
			sb.append(this.getData().toString());
		}
		return sb.toString();
	}//end - toString
	
}//end - BSTNode

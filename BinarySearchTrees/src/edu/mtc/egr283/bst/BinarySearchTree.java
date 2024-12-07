package edu.mtc.egr283.bst;

import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {
	
	//Variables
	private BSTNode<T> root;
	
	//Constants
	private static final String SPACE = " ";
	
	//Constructors
	/**
	 * Default 'no-args' constructor; automatically sets the root
	 * to 'null'.
	 */
	public BinarySearchTree()
	{
		this(null);
	}//end - default 'no-args' constructor
	
	/**
	 * Constructor for the BinarySearchTree. All it does is set the
	 * root for the new constructor.
	 * @param newRoot sets the new root for the Binary search tree.
	 */
	public BinarySearchTree(BSTNode<T> newRoot)
	{
		this.setRoot(newRoot);
	}//end - Constructor
	
	//Methods
		
	/**
	 * Accessor method to grab the current root of the 
	 * binary search tree.
	 * @return the root of the Binary Search Tree
	 */
	public BSTNode<T> getRoot()
	{
		return this.root;
	}//end - getRoot

	/**
	 * Standard mutator method: replaces the root node of choice with a new root node.
	 * @param newRoot new root node
	 */
	public void setRoot(BSTNode<T> newRoot)
	{
		this.root = newRoot;
	}//end - setRoot
	
	/**
	 * Adds a new node into the Binary Tree. If the root is empty,
	 * then the desired data will become the new root.
	 * Else depending on if it is greater than or less than the root, it will be placed
	 * in the appropriate node(Left if less, Right if greater than).
	 * @param data the desired data that the user wants to place in the tree.
	 */
	public void addNode(T data)
	{
		BSTNode<T> insNode = new BSTNode<T>(data);
		this.setRoot(this.addNodeInternal(this.getRoot(), insNode));
	}//end - addNode
	
	/**
	 * Removes the node from the binary search tree. Calls in the Search method to look for the data.
	 * If it can't find it, then it'll print out an error stating that said piece of data cannot be found.
	 * @param data the desired data that the user wants to remove from the binary tree.
	 */
	public void removeNode(T data)
	{
		if(search(data))
		{
			this.removeNodeInternal(this.root, data);
		}//end - NESTED if statement
		else
		{
			System.out.println("ERROR - " + data + " not found!!");
		}//end - if/else statement
		
	}//end - removeNode
	
	/**
	 * Searches for the desired data, and if it finds the desired data
	 * then it will return true, otherwise it will return false.
	 * @param data any generic(depending on what said generic is) that the user desires to find.
	 * @return true or false
	 */
	public boolean search(T data)
	{
		return this.searchInternal(this.getRoot(), data);
	}//end - Search
	
	/**
	 * Displays the order of the nodes in preorder traversal.
	 * @param node the desired node to start the traversal from.
	 * @return A string displaying the order of nodes in preorder traversal.
	 */
	public String preOrderTraversal(BSTNode<T> node)
	{
		return this.internalPreOrderTraversal(node);
	}//end - preOrder
	
	/**
	 * Displays the order of nodes in inorder traversal.
	 * @param node the desired node to start the traversal from.
	 * @return A string displaying the order of nodes in inorder traversal.
	 */
	public String inOrderTraversal(BSTNode<T> node)
	{
		return this.internalInOrderTraversal(node);
	}//end - inOrder
	
	/**
	 * Displays the order of nodes in postorder traversal.
	 * @param node the desired node to start the traversal from.
	 * @return A string displaying the order of nodes in postorder traversal.
	 */
	public String postOrderTraversal(BSTNode<T> node)
	{
		return this.internalPostOrderTraversal(node);
	}//end - postOrder
	
	/**
	 * Displays the order of nodes in level order traversal. Compared to the last three
	 * this was a little tricky in implementing. Ended up using a stack to display the position
	 * of each desired node.
	 * @param node the desired node to start the traversal from.
	 * @return A string displaying the order of nodes in level order traversal.
	 */
	public String levelOrderTraversal(BSTNode<T> node)
	{
		return this.internalLevelOrderTraversal(node);
	}//end - levelOrder
	
	/**
	 * Usual toString Method; prints out the order of roots.
	 */
	@Override
	public String toString()
	{
		return this.toStringInternal(this.getRoot());
	}//end - toString
	
	
//	PRIVATE METHODS FOR RECURSION USE
	
	/*
	 * if there is no root, then the new node will become the new root.
	 * else if there root is greater than the node, then the node will recursively move to the left.
	 * else, the node will recursively move to the right.
	 */
	private BSTNode<T> addNodeInternal(BSTNode<T> binaryRoot, BSTNode<T> node)
	{
		if(binaryRoot == null)
		{
			binaryRoot = node;
		}else if(binaryRoot.compareTo(node) > 0)
		{
			binaryRoot.setLeft(this.addNodeInternal(binaryRoot.getLeft(), node));
		}else
		{
			binaryRoot.setRight(this.addNodeInternal(binaryRoot.getRight(), node));
		}//end - if/else statement
		return binaryRoot;
	}//end - internalAddNode
	
	/*
	 * Removes the desired node, and it uses recursion to go through
	 * the root and leaves of the tree.
	 */
	private BSTNode<T> removeNodeInternal(BSTNode<T> node, T data)
	{

		if(node.getData().compareTo(data) > 0)
		{
			node.setLeft(this.removeNodeInternal(node.getLeft(), data));
		}else if(node.getData().compareTo(data) < 0)
		{
			node.setRight(this.removeNodeInternal(node.getRight(), data));
		}else
		{
			if(node.getLeft() == null && node.getRight() == null)
			{
				//have to use make equal to, instead of BSTNode operator
				//since we're pretty much deleting the node by setting
				//EVERYTHING to null
				node = null;
			}
			else if(node.getRight() == null)
			{
				node = node.getRight();
				while(node.getLeft() != null)
				{
					node.setLeft(node.getLeft());
				}//end - while loop
			}//end - if/else statement
			else
			{
				node = node.getLeft();
				while(node.getRight() != null)
				{
					node = node.getRight();
				}//end - while loop
			}//end - if/else statement
		}//end - if/else statement
			
		return node;
	}//end - removeNodeInternal
	
	/*
	 * Whole purpose of this method is to mostly go down from a root to a
	 * leaf node, in order to find the desired root.
	 */
	private boolean searchInternal(BSTNode<T> node, T data)
	{
		boolean rv = false;

		if(node != null)
		{
			if(node.getData().equals(data))
			{
				rv = true;
			}else if(data.compareTo(node.getData()) > 0)
			{
				rv = this.searchInternal(node.getRight(), data);
			}else
			{
				//Automatically assume that if comparable node data is not greater than or equal to 0
				//then it must be less than 0
				rv = this.searchInternal(node.getLeft(), data);
			}//end - if/else statement
		}//end - if/else statement
		
		return rv;
	}//end - searchRecursor
	
	//ORDER METHODS
	
	
	/*
	 * preorder, inorder, and postorder are about the same in how the
	 * code is executed for each traversal.
	 */
	private String internalPreOrderTraversal(BSTNode<T> node)
	{
		StringBuffer sb = new StringBuffer();
		//null pointer Check
		if(node != null)
		{
			sb.append(node.toString());
			sb.append(BinarySearchTree.SPACE);
			sb.append(this.internalPreOrderTraversal(node.getLeft()));
			sb.append(this.internalPreOrderTraversal(node.getRight()));
		}//end - if statement
		return sb.toString();
	}//end - internal PreOrder
	
	private String internalInOrderTraversal(BSTNode<T> node)
	{
		StringBuffer sb = new StringBuffer();
		//null pointer Check
		if(node != null)
		{
			sb.append(this.internalInOrderTraversal(node.getLeft()));
			sb.append(node.toString());
			sb.append(BinarySearchTree.SPACE);
			sb.append(this.internalInOrderTraversal(node.getRight()));
		}//end - if statement
		return sb.toString();
	}//end - internal PreOrder
	
	private String internalPostOrderTraversal(BSTNode<T> node)
	{
		StringBuffer sb = new StringBuffer();
		//null pointer Check
		if(node != null)
		{
			sb.append(this.internalPostOrderTraversal(node.getLeft()));
			sb.append(this.internalPostOrderTraversal(node.getRight()));
			sb.append(node.toString());
			sb.append(BinarySearchTree.SPACE);
		}//end - if statement
		return sb.toString();
	}//end - internal PreOrder
	
	
	/*
	 * Level order uses a stack to grab the nodes and place them in each level
	 */
	private String internalLevelOrderTraversal(BSTNode<T> node)
	{
		StringBuffer sb = new StringBuffer();
		Stack<BSTNode<T>> stck = new Stack<BSTNode<T>>();
		stck.push(node);
		
		while(!stck.isEmpty())
		{
			//pop and print the head
			BSTNode<T> temp = stck.pop();
			sb.append(temp.getData() + " ");
			
			//push in the left or right child if the node has any child nodes
			if(temp.getLeft() != null)
			{
				stck.push(temp.getLeft());
			}//end - if statement
			if(temp.getRight() != null)
			{
				stck.push(temp.getRight());
			}//end - if statement
		}//end - while loop
		
		return sb.toString();
	}//end - internalLevelOrder
	
	//Helper method for toString to recursively print out the data from the 
	//binary search tree
	private String toStringInternal(BSTNode<T> node)
	{
		StringBuffer sb = new StringBuffer();
		//null pointer check
		if(node != null)
		{
			sb.append(this.toStringInternal(node.getLeft()));
			sb.append(node.toString() + BinarySearchTree.SPACE);
			sb.append(this.toStringInternal(node.getRight()));
		}//end - if statement
		return sb.toString();
	}//end - toStringInternal
}//end - BinarySearchTree

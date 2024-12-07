package edu.mtc.egr283.bst;

/**
 * @author Therin Emmons
 * Project 07
 * Current Date: 04/11/24
 * Due Date: 04/15/24
 * 
 * Project consists of toying with a binary search tree with the functions of getting a root, setting a root,
 * adding nodes, removing nodes, searching for nodes, and seeing the nodes in preorder traversal, inorder traversal
 * postorder traversal, and levelorder traversal.
 */
public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTNode<String> one = new BSTNode<String>("0");
		BSTNode<String> two = new BSTNode<String>("2");
		BSTNode<String> three = new BSTNode<String>("3");
		BSTNode<String> four = new BSTNode<String>("4");
		BSTNode<String> five = new BSTNode<String>("5");
		BSTNode<String> six = new BSTNode<String>("6");
		BSTNode<String> seven = new BSTNode<String>("7");
	
		
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		
		System.out.println("Grabbing one: " + one.getData());
		System.out.print("Assigning one a new node: ");
		one.setData("1");
		System.out.println(one.getData());
		two.setLeft(one);
		two.setRight(three);
		System.out.printf("Parent Node: %s Left Child: %s Right Child: %s \n", two.toString(), two.getLeft().toString(), two.getRight().toString());
		System.out.println("One equal to Two? " + one.equals(two));
		System.out.println("Two equal to Two? " + two.equals(two));
		System.out.println("Comparing one and two: " + one.compareTo(two));
		System.out.println();
		
		
		System.out.println("BUILDING TREE");
		bst.setRoot(four);
		bst.addNode(two.getData());
		bst.addNode(six.getData());
		bst.addNode(one.getData());
		bst.addNode(three.getData());
		bst.addNode(five.getData());
		bst.addNode(seven.getData());
		
		System.out.println("Root of Tree: " + bst.getRoot());
		System.out.println("Printing: " + bst.toString());
		System.out.println("Find 4: " + bst.search("4"));
		System.out.println();
		
		System.out.println("Preorder: " + bst.preOrderTraversal(bst.getRoot()));
		System.out.println("Postorder: " + bst.postOrderTraversal(bst.getRoot()));
		System.out.println("Inorder: " + bst.inOrderTraversal(bst.getRoot()));
		System.out.println("Level order: " + bst.levelOrderTraversal(bst.getRoot()));
		

		System.out.println("Removing nodes 1, 5, and 7");
		bst.removeNode("1");
		bst.removeNode("5");
		bst.removeNode("7");
		System.out.println("Printing: " + bst.toString());
	}//end - main

}//end - class binary search tree driver

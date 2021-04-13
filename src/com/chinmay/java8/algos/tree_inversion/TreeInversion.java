package com.chinmay.java8.algos.tree_inversion;

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;
	
	//Logic to invert the binary tree (left to right mirror reflection)
	Node invertBT()
	{
		return invertBT(root);
	}
	Node invertBT(Node node)
	{
		//Recursive calls are usually a 4 step approach
		//FIRST: Write the terminating condition, else the recursive function call will go into indefinite loop
		if (node==null)
			return node;
		
		//SECOND: operate on the direct elements of the class
		Node temp = node.right;
		node.right = node.left;
		node.left = temp;
		
		//THIRD: Call the method recursively on a modified element
		invertBT(node.left);
		invertBT(node.right);
		
		//FOURTH: Return from the recursive method
		return node;
	}
	
	//Logic to print in order traversal of the binary tree (left - root - right)
	void printInOrder()
	{
		printInOrder(root);
	}
	void printInOrder(Node node)
	{
		if(node==null)
			return;
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}
	
	public static void main(String[] args) {
		//Initialize a sample binary tree
		BinaryTree btree = new BinaryTree();
		btree.root = new Node(1);
		btree.root.left = new Node(2);
		btree.root.right = new Node(3);
		btree.root.left.left = new Node(4);
		btree.root.left.right = new Node(5);
		btree.root.right.left = new Node(6);
		btree.root.right.right = new Node(7);
		btree.root.left.left.left = new Node(8);
		btree.root.left.left.right = new Node(9);
		btree.root.left.right.left = new Node(10);
		//See the comment below to visualize the tree graph
		
		System.out.println("\nORIGINAL TREE\n-----------------------");
		
		//Print in order traversal of the input tree
		btree.printInOrder();
		
		System.out.println("\n\nINVERTED TREE\n-----------------------");
		//Print in order traversal of the inverted tree
		btree.invertBT();
		btree.printInOrder();
	}

/**
 * 
 * The tree inversion can be tested using the command:
 *     java -cp . com.chinmay.java8.algos.tree_inversion.BinaryTree
 * 
 * Inspiration:  https://www.cis.upenn.edu/~matuszek/cit594-2003/Assignments/05A-binary-tree-editor.html 
 * The Example binary tree in the above main() method is depicted below (referred above inspiration)
 * Right child is written above the left node as it looks more natural.
 * 
 *   1
 *    \__3
 *    |  \__7
 *    |  |
 *    |  |__6
 *    |
 *    |
 *    |__2
 *       \__5
 *       |  \__null
 *       |  |
 *       |  |__10
 *       |
 *       |__4
 *          \__9
 *          |
 *          |__8
 * 
 * The In order traversal of the tree will be: 8 4 9 2 10 5 1 6 3 7
 * 
 */
	
}

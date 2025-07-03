package tree;

import java.util.Stack;

class NodeT 
{ 
int data; 
NodeT leftChild; 
NodeT rightChild; 
NodeT(int data) 
{ 
    this.data = data;  
} 
} 
  
class BinaryTree { 
	NodeT rootNode; 
  
// function to print the 
// zigzag traversal 
void printZigZagTraversal() { 
      
    // if null then return 
    if (rootNode == null) { 
    return; 
    } 
  
    // declare two stacks 
    Stack<NodeT> currentLevel = new Stack<>(); 
    Stack<NodeT> nextLevel = new Stack<>(); 
  
    // push the root 
    currentLevel.push(rootNode); 
    boolean leftToRight = true; 
  
    // check if stack is empty 
    while (!currentLevel.isEmpty()) { 
  
    // pop out of stack 
    	NodeT node = currentLevel.pop(); 
      
    // print the data in it 
    System.out.print(node.data + " "); 
  
    // store data according to current 
    // order. 
    if (leftToRight) { 
        if (node.leftChild != null) { 
        nextLevel.push(node.leftChild); 
        } 
          
        if (node.rightChild != null) { 
        nextLevel.push(node.rightChild); 
        } 
    } 
    else { 
        if (node.rightChild != null) { 
        nextLevel.push(node.rightChild); 
        } 
          
        if (node.leftChild != null) { 
        nextLevel.push(node.leftChild); 
        } 
    } 
  
    if (currentLevel.isEmpty()) { 
        leftToRight = !leftToRight; 
        Stack<NodeT> temp = currentLevel; 
        currentLevel = nextLevel; 
        nextLevel = temp; 
    } 
    } 
} 
} 
  
public class zigZagTreeTraversal { 
  
// driver program to test the above function 
public static void main(String[] args)  
{ 
    BinaryTree tree = new BinaryTree(); 
    tree.rootNode = new NodeT(1); 
    tree.rootNode.leftChild = new NodeT(2); 
    tree.rootNode.rightChild = new NodeT(3); 
    tree.rootNode.leftChild.leftChild = new NodeT(7); 
    tree.rootNode.leftChild.rightChild = new NodeT(6); 
    tree.rootNode.rightChild.leftChild = new NodeT(5); 
    tree.rootNode.rightChild.rightChild = new NodeT(4); 
  
    System.out.println("ZigZag Order traversal of binary tree is"); 
    tree.printZigZagTraversal(); 
} 
}
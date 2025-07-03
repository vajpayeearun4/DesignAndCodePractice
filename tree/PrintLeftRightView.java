package tree;

public class PrintLeftRightView {
	
	
	 NodeSucc root; 
	    static int max_level = 0; 
	  
	    // recursive function to print left view 
	    void leftViewUtil(NodeSucc node, int level) 
	    { 
	        // Base Case 
	        if (node == null) 
	            return; 
	  
	        // If this is the first node of its level 
	        if (max_level < level) { 
	            System.out.print(" " + node.data); 
	            max_level = level; 
	        } 
	  
	        // Recur for left and right subtrees 
	        leftViewUtil(node.left, level + 1); 
	        leftViewUtil(node.right, level + 1); 
	    }
	    
	    
	    //    // Recursive function to print right view of a binary tree. 

	    void rightViewUtil(NodeSucc node, int level, int levelRight) { 
	    	  
	        // Base Case 
	        if (node == null)  
	            return; 
	  
	        // If this is the last Node of its level 
	        if (max_level < level) { 
	            System.out.print(node.data + " "); 
	            max_level = level; 
	        } 
	  
	        // Recur for right subtree first, then left subtree 
	        rightViewUtil(node.right, level + 1, max_level); 
	        rightViewUtil(node.left, level + 1, max_level); 
	    } 
	    
	    
	    
	    
	  
	    // A wrapper over leftViewUtil() 
	    void leftView() 
	    { 
	        leftViewUtil(root, 1); 
	    } 
	  
	    /* testing for example nodes */
	    public static void main(String args[]) 
	    { 
	        /* creating a binary tree and entering the nodes */
	    	PrintLeftRightView tree = new PrintLeftRightView(); 
	        tree.root = new NodeSucc(12); 
	        tree.root.left = new NodeSucc(10); 
	        tree.root.right = new NodeSucc(30); 
	        tree.root.right.left = new NodeSucc(25); 
	        tree.root.right.right = new NodeSucc(40); 
	  
	        tree.leftView(); 
	    } 

}

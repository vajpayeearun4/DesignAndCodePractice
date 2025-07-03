package tree;

public class BinaryTreeFun {

	
	
	// Delete leaf nodes from binary search tree.  
	static NodeSucc leafDelete(NodeSucc root)  
	{  
	    if (root.left == null && root.right == null) {  
	        return null;  
	    }  
	  
	    // Else recursively delete in left and right  
	    // subtrees.  
	    root.left = leafDelete(root.left);  
	    root.right = leafDelete(root.right);  
	  
	    return root;  
	}  
	
	
	//find kth smallest
	 static int count=0;
	    int k =5;
	
	 void findKth(NodeSucc node)  
	    { 
	        if (node == null) 
	            return ; 
	   
	      
	     
	        
	        findKth(node.left );
	        
	           count++;
	        if (count ==k) 
	            System.out.println(node.data); 
	        
	        
	        findKth(node.right);
	   
	      
	    } 
	 
	 
	 
	// Java program to convert binary tree into its mirror 
	 NodeSucc mirror(NodeSucc node) 
	    { 
	        if (node == null) 
	            return node; 
	  
	        /* do the subtrees */
	        NodeSucc left = mirror(node.left); 
	        NodeSucc right = mirror(node.right); 
	  
	        /* swap the left and right pointers */
	        node.left = right; 
	        node.right = left; 
	  
	        return node; 
	    } 
	
	
}

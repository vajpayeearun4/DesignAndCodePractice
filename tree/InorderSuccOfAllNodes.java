package tree;

class NodeSucc  
{ 
    int data; 
    NodeSucc left, right, next; 
   
    NodeSucc(int item)  
    { 
        data = item; 
        left = right = next = null; 
    } 
}
	class InOrderSuccOfAllNodes  
	{ 
	    NodeSucc root; 
	    static NodeSucc next = null; 
	   
	    /* Set next of p and all descendents of p by traversing them in  
	       reverse Inorder */
	    void populateNext(NodeSucc node)  
	    { 
	        // The first visited node will be the rightmost node 
	        // next of the rightmost node will be NULL 
	        if (node != null)  
	        { 
	            // First set the next pointer in right subtree 
	            populateNext(node.right); 
	   
	            // Set the next as previously visited node in reverse Inorder 
	            node.next = next; 
	   
	            // Change the prev for subsequent node 
	            next = node; 
	   
	            // Finally, set the next pointer in left subtree 
	            populateNext(node.left); 
	        } 
	    } 
	   
	    /* Driver program to test above functions*/
	    public static void main(String args[])  
	    { 
	        /* Constructed binary tree is 
	            10 
	           /   \ 
	          8      12 
	         / 
	        3    */
	    	InOrderSuccOfAllNodes tree = new InOrderSuccOfAllNodes(); 
	        tree.root = new NodeSucc(10); 
	        tree.root.left = new NodeSucc(8); 
	        tree.root.right = new NodeSucc(12); 
	        tree.root.left.left = new NodeSucc(3); 
	   
	        // Populates nextRight pointer in all nodes 
	        tree.populateNext(tree.root); 
	   
	        // Let us see the populated values 
	        NodeSucc ptr = tree.root.left.left; 
	        while (ptr != null)  
	        { 
	            // -1 is printed if there is no successor 
	            int print = ptr.next != null ? ptr.next.data : -1; 
	            System.out.println("Next of " + ptr.data + " is: " + print); 
	            ptr = ptr.next; 
	        } 
	    } 
	} 
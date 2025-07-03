package tree;
class BinarySearchTreeLCA  
{ 
    NodeSucc root; 
       
    /* Function to find LCA of n1 and n2. The function assumes that both 
       n1 and n2 are present in BST */
    NodeSucc lca(NodeSucc node, int n1, int n2)  
    { 
        if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.data > n1 && node.data > n2) 
            return lca(node.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.data < n1 && node.data < n2)  
            return lca(node.right, n1, n2); 
   
        return node; 
    } 
    
   
    /* Driver program to test lca() */
    public static void main(String args[])  
    { 
        // Let us construct the BST shown in the above figure 
        BinarySearchTreeLCA tree = new BinarySearchTreeLCA(); 
        tree.root = new NodeSucc(20); 
        tree.root.left = new NodeSucc(8); 
        tree.root.right = new NodeSucc(22); 
        tree.root.left.left = new NodeSucc(4); 
        tree.root.left.right = new NodeSucc(12); 
        tree.root.left.right.left = new NodeSucc(10); 
        tree.root.left.right.right = new NodeSucc(14); 
   
        int n1 = 10, n2 = 14; 
        NodeSucc t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 14; 
        n2 = 8; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
   
        n1 = 10; 
        n2 = 22; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
        
        
   
    } 
}
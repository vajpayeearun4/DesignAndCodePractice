package tree;

class BinaryTreeToDll  
{ 
    NodeSucc root; 
       
    // head --> Pointer to head node of created doubly linked list 
    NodeSucc head; 
       
    // Initialize previously visited node as NULL. This is 
    // static so that the same value is accessible in all recursive 
    // calls 
    static NodeSucc prev = null; 
   
    // A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoubleLinkedList(NodeSucc root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    } 
   
    /* Function to print nodes in a given doubly linked list */
    void printList(NodeSucc node) 
    { 
        while (node != null)  
        { 
            System.out.print(node.data + " "); 
            node = node.right; 
        } 
    } 
   
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        // Let us create the tree as shown in above diagram 
        BinaryTreeToDll tree = new BinaryTreeToDll(); 
        tree.root = new NodeSucc(10); 
        tree.root.left = new NodeSucc(12); 
        tree.root.right = new NodeSucc(15); 
        tree.root.left.left = new NodeSucc(25); 
        tree.root.left.right = new NodeSucc(30); 
        tree.root.right.left = new NodeSucc(36); 
   
        // convert to DLL 
        tree.BinaryTree2DoubleLinkedList(tree.root); 
           
        // Print the converted List 
        tree.printList(tree.head); 
   
    } 
}
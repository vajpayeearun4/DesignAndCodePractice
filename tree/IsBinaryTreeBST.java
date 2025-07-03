package tree;
public class IsBinaryTreeBST 
{ 
    
    NodeSucc root; 
  

    boolean isBST()  { 
        return isBSTUtil(root, Integer.MIN_VALUE, 
                               Integer.MAX_VALUE); 
    } 
  
   
    boolean isBSTUtil(NodeSucc node, int min, int max) 
    { 
        if (node == null) 
            return true; 
  
        if (node.data < min || node.data > max) 
            return false; 
  
        return (isBSTUtil(node.left, min, node.data-1) && 
                isBSTUtil(node.right, node.data+1, max)); 
    } 
  
    public static void main(String args[]) 
    { 
        IsBinaryTreeBST tree = new IsBinaryTreeBST(); 
        tree.root = new NodeSucc(4); 
        tree.root.left = new NodeSucc(2); 
        tree.root.right = new NodeSucc(5); 
        tree.root.left.left = new NodeSucc(1); 
        tree.root.left.right = new NodeSucc(3); 
  
        if (tree.isBST()) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 
}
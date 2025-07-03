package tree;
import java.util.LinkedList;
import java.util.Queue;

/*class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}*/

public class LevelOrder {

	// Root of the Binary Tree
	NodeSucc root;

	public LevelOrder() {
		root = null;
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	
	int height(NodeSucc root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print nodes at the given level */
	void printGivenLevel(NodeSucc root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void main(String args[]) {
		LevelOrder tree = new LevelOrder();
		tree.root = new NodeSucc(1);
		tree.root.left = new NodeSucc(2);
		tree.root.right = new NodeSucc(3);
		tree.root.left.left = new NodeSucc(4);
		tree.root.left.right = new NodeSucc(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

	
	void printLevelOrderUsingQueue()  
    { 
        Queue<NodeSucc> queue = new LinkedList<NodeSucc>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
  
            /* poll() removes the present head. 
            For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            NodeSucc tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    }
	
}

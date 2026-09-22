package final_prep.dsa.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
public class CopyListWithRandomPointer {

    // with map
    public Node copyRandomList(Node head) {
        Map<Node, Node> originalNewNodeMap = new LinkedHashMap<>();
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            originalNewNodeMap.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node copyNode = originalNewNodeMap.get(curr);
            copyNode.next = originalNewNodeMap.get(curr.next);
            copyNode.random = originalNewNodeMap.get(curr.random);
            curr = curr.next;
        }
        return originalNewNodeMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
package final_prep.dsa.array.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfsClone(node, new HashMap<>());
    }

    Node dfsClone(Node node, Map<Node, Node> cloneMap) {
        if (cloneMap.containsKey(node)) {
            return cloneMap.get(node);
        }
        Node clonedNode = new Node(node.val);
        cloneMap.put(node, clonedNode);

        for (Node padosi : node.neighbors) {
            clonedNode.neighbors.add(dfsClone(padosi, cloneMap));
        }

        return clonedNode;

    }
}

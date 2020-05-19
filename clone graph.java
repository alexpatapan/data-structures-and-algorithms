/*

Leetcode 133 - Clone Graph
This solution implements a BFS approach to traverse the graph, copying each node as it goes.

// Definition for a Node.
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

*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        ArrayDeque<Node> queueOriginal = new ArrayDeque<>();
        
        // old node -> copy
        HashMap<Node, Node> visited = new HashMap<>();
        
        Node result = new Node(node.val);       
        visited.put(node, result);     
        queueOriginal.add(node);
        
        while (!queueOriginal.isEmpty()) {
            Node originalNode = queueOriginal.pop();
            Node resultNode = visited.get(originalNode);
            
            for (Node neighbour : originalNode.neighbors) {
                if (visited.containsKey(neighbour)) {
                    // we have created a copy already
                    resultNode.neighbors.add(visited.get(neighbour));
                } else {
                    // we need to make a new copy
                    Node newNode = new Node(neighbour.val);
                    queueOriginal.add(neighbour);    
                    visited.put(neighbour, newNode);
                    resultNode.neighbors.add(newNode);
                   
                }
            }
            
        }
        return result;
    }
}

package edu.LeetCode.Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node target, Map<Node, Node> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        ArrayList<Node> list = new ArrayList<>();
        Node replica = new Node(target.val, list);
        map.put(target, replica);
        for (Node neighbour : target.neighbors) {
            list.add(dfs(neighbour, map));
        }
        return replica;
    }



}

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

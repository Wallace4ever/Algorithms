package edu.KeyToOffer.TearDown;

import java.util.Deque;
import java.util.LinkedList;

public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root == null) return "#!";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                sb.append(root.val).append("!");
                stack.push(root);
                root=root.left;
            }
            sb.append("#!");
            if (stack.size()==0) break;
            root = stack.pop();
            root = root.right;
        }
        return sb.toString();
    }

    String[] values = null;
    int index = 0;

    TreeNode Deserialize(String str) {
        values = str.split("!");
        return preOrder();
    }

    private TreeNode preOrder() {
        if (values[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index++]));
        node.left = preOrder();
        node.right = preOrder();
        return node;
    }
}

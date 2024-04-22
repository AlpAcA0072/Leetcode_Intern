package suixianglu.tree.L;

import ulib.*;

import java.util.Deque;
import java.util.LinkedList;

public class l0111 {
    class Solution {
        int depth = 0;

        public int minDepth(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) deque.addLast(root);
            TreeNode node;

            while (!deque.isEmpty()) {
                depth++;
                for (int size = deque.size(); size > 0; size--) {
                    node = deque.removeFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                    if (node.left == null && node.right == null) return depth;
                }
            }

            return depth;
        }

    }
}

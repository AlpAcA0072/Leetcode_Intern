package suixianglu.Tree.L;

import ulib.*;

import java.util.Deque;
import java.util.LinkedList;

public class l0104 {
    class Solution {
        int depth = 0;

        public int maxDepth(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) deque.addLast(root);
            TreeNode node;

            while (!deque.isEmpty()) {
                depth++;
                for (int size = deque.size(); size > 0; size--) {
                    node = deque.removeFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }
            }

            return depth;
        }

    }
}

package suixianglu.tree.S;

import ulib.*;

import java.util.*;

public class s0111 {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) {
                min_depth = Math.min(minDepth(root.left), min_depth);
            }
            if (root.right != null) {
                min_depth = Math.min(minDepth(root.right), min_depth);
            }

            return min_depth + 1;
        }
    }

    class Solution2 {
        class QueueNode {
            TreeNode node;
            int depth;

            public QueueNode(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<QueueNode> queue = new LinkedList<QueueNode>();
            queue.offer(new QueueNode(root, 1));
            while (!queue.isEmpty()) {
                QueueNode nodeDepth = queue.poll();
                TreeNode node = nodeDepth.node;
                int depth = nodeDepth.depth;
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, depth + 1));
                }
            }

            return 0;
        }
    }
}

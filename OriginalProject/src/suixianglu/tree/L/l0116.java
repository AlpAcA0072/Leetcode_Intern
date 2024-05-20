package suixianglu.tree.L;

import java.util.LinkedList;
import java.util.Queue;

public class l0116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        // 层序遍历
        public Node connect(Node root) {
            Queue<Node> queue = new LinkedList<>();
            if (root != null) queue.add(root);

            Node node;
            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; size--) {
                    node = queue.remove();
                    // peek() will return null if queue is empty.
                    if (size == 1) {
                        node.next = null;
                    } else {
                        node.next = queue.peek();
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }

            return root;
        }
    }

    class Solution2 {
        // 利用已有的next
        public Node connect(Node root) {
            if (root == null) return null;

            Node node, leftNode = root;
            while (leftNode.left != null) {
                node = leftNode;
                while (node != null) {

                    node.left.next = node.right;

                    if (node.next != null) {
                        node.right.next = node.next.left;
                    }
                    node = node.next;
                }

                leftNode = leftNode.left;
            }

            return root;
        }
    }
}

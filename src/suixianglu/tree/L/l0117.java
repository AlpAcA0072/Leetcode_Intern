package suixianglu.tree.L;

import java.util.LinkedList;
import java.util.Queue;

public class l0117 {
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
        // last: 上一个node，因为一直指向当前node左侧的位置，所以初始化为空
        // currLayerLeft: 当前层最左侧的node
        Node last = null, currLayerLeft;

        // 利用已有的next
        public Node connect(Node root) {
            Node node = root;
            currLayerLeft = root;
            while (node != null) {
                // 重置currLayerLeft
                currLayerLeft = node;
                for (; node != null; node = node.next) {
                    // node.left和node.right是last的next结点
                    handle(node.left);
                    handle(node.right);
                }
                // last重新置空
                last = null;
                // 用当前层的最左侧结点计算下一层的最左侧结点
                node = calculateNextLeft(currLayerLeft);
            }
            return root;
        }

        private void handle(Node node) {
            if (last == null) {
                last = node;
                return;
            }
            if (node != null) {
                last.next = node;
                last = node;
            }
        }

        private Node calculateNextLeft(Node node) {
            while (node != null && node.left == null && node.right == null) {
                node = node.next;
            }
            if (node != null && node.left != null) {
                return node.left;
            } else if (node != null) {
                return node.right;
            } else return null;
        }
    }

    class Solution3 {
        // last: 上一个node，因为一直指向当前node左侧的位置，所以初始化为空
        // currLayerLeft: 当前层最左侧的node
        Node last = null, nextLeft = null;

        // 利用已有的next
        public Node connect(Node root) {
            Node node = root;
            while (node != null) {
                for (; node != null; node = node.next) {
                    // node.left和node.right是last的next结点
                    handle(node.left);
                    handle(node.right);
                }
                // last重新置空
                last = null;
                // 用当前层的最左侧结点计算下一层的最左侧结点
                node = nextLeft;
                nextLeft = null;
            }
            return root;
        }

        private void handle(Node node) {
            // 相比solution2，优化了计算nextLeft部分。
            // 因为在handle中会遍历到下一层的所有结点，当nextLeft为空时，说明访问到的node是下一层的最左侧结点。
            if (nextLeft == null) {
                nextLeft = node;
            }
            if (last == null) {
                last = node;
                return;
            }
            if (node != null) {
                last.next = node;
                last = node;
            }
        }

    }

}

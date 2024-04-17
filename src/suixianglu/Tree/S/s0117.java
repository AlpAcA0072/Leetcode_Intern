package suixianglu.Tree.S;

import java.util.ArrayDeque;
import java.util.Queue;

public class s0117 {
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
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new ArrayDeque<Node>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                Node last = null;
                for (int i = 1; i <= n; ++i) {
                    Node f = queue.poll();
                    if (f.left != null) {
                        queue.offer(f.left);
                    }
                    if (f.right != null) {
                        queue.offer(f.right);
                    }
                    if (i != 1) {
                        last.next = f;
                    }
                    last = f;
                }
            }
            return root;
        }
    }

    class Solution2 {
        Node last = null, nextStart = null;

        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node start = root;
            while (start != null) {
                last = null;
                nextStart = null;
                for (Node p = start; p != null; p = p.next) {
                    if (p.left != null) {
                        handle(p.left);
                    }
                    if (p.right != null) {
                        handle(p.right);
                    }
                }
                start = nextStart;
            }
            return root;
        }

        public void handle(Node p) {
            if (last != null) {
                last.next = p;
            }
            if (nextStart == null) {
                nextStart = p;
            }
            last = p;
        }
    }
}

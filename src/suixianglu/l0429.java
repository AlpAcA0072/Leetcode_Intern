package suixianglu;

import java.util.*;

public class l0429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        List<List<Integer>> arr;

        public List<List<Integer>> levelOrder(Node root) {
            arr = new ArrayList<>();
            NTreeLevelOrderTraversalRecursive(root, 0);
            return arr;
        }

        private void NTreeLevelOrderTraversalRecursive(Node node, int depth) {
            if (node != null) {
                if (depth + 1 > arr.size()) {
                    arr.add(new ArrayList<>());
                }

                arr.get(depth).add(node.val);

                for (Node n : node.children) {
                    NTreeLevelOrderTraversalRecursive(n, depth + 1);
                }
            }
        }
    }
}

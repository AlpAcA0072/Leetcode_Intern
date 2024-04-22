package suixianglu.tree.L;

import ulib.TreeNode;

public class l0222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;

        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(5);
        left1.left = first;
        left1.right = second;
        TreeNode third = new TreeNode(6);
        TreeNode forth = new TreeNode(7);
        right1.left = third;
        right1.right = forth;

        l0222 l0222 = new l0222();
        Solution2 s = l0222.new Solution2();
        int i = s.countNodes(root);
        System.out.println(i);
    }

    // 看似加快了，实则还是要遍历每个结点
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            TreeNode leaf = root;
            int depth = 0;
            while (leaf.left != null) {
                leaf = leaf.left;
                depth++;
            }
            if (depth == 0) return 1;

            // 对应深度 满二叉树 的数量，要减掉空节点的数量
            int num = (int) Math.pow(2, depth + 1) - 1;

            return num - DFS(root, depth);
        }

        private int DFS(TreeNode node, int depth) {
            int count = 0;
            if (depth == 1) {
                // is leaf node
                if (node.left == null) count++;
                if (node.right == null) count++;
                return count;
            } else {
                count += DFS(node.right, depth - 1);
                count += DFS(node.left, depth - 1);
            }
            return count;
        }
    }

    // 二分查找 + 位运算
    class Solution2 {
        public int countNodes(TreeNode root) {
            // 如果根结点为第0层
            // 则第i层的结点可以表示为长度为i的二进制数
            // 第0层有1个结点，不用表示
            // 第1层有2个结点：0，1
            // 第2层有4个结点：00，01，10，11
            // 第3层有8个结点：000，001，010，011，100，101，110，111
            // 而且可以用二进制数表示结点在树中的位置
            // 比如：011，就是root.left.right.right
            // 所以0 ---> left，1 ---> right
            // 在知道这是一棵**完全二叉树**，而且知道树的**深度**的情况下，我们就可以这样对 **叶子层** 进行二分查找

            if (root == null) return 0;
            if (root.left == null) return 1;

            TreeNode leaf = root;
            int depth = 0;
            while (leaf.left != null) {
                leaf = leaf.left;
                depth++;
            }

            // 对应 深度 - 1 满二叉树 的数量，要加上叶子节点的数量
            int num = (int) Math.pow(2, depth) - 1;

            return num + binarySearch(0, (int) Math.pow(2, depth) - 1, root, depth) + 1;
        }

        private int binarySearch(int left, int right, TreeNode root, int depth) {
            // left != null && right == null
            // left就是我们要的叶子结点的最后一个
            if (left == right - 1 || left == right) {
                if (findNode(right, root, depth) != null) return right;
                return left;
            }

            int mid = (left + right) / 2;
            if (findNode(mid, root, depth) == null) {
                right = mid;
            } else {
                left = mid;
            }
            return binarySearch(left, right, root, depth);
        }

        private TreeNode findNode(int bits, TreeNode root, int depth) {
            int k = 1 << (depth - 1);
            TreeNode node = root;
            while (k > 0) {
                if ((bits & k) == 0) {
                    node = node.left;
                } else node = node.right;
                k = k >> 1;
            }
            return node;
        }
    }

    class Solution3 {
        public int countNodes(TreeNode root) {
            // 如果根结点为第0层
            // 则第i层的结点可以表示为长度为i的二进制数
            // 第0层有1个结点，不用表示
            // 第1层有2个结点：0，1
            // 第2层有4个结点：00，01，10，11
            // 第3层有8个结点：000，001，010，011，100，101，110，111
            // 而且可以用二进制数表示结点在树中的位置
            // 比如：011，就是root.left.right.right
            // 所以0 ---> left，1 ---> right
            // 在知道这是一棵**完全二叉树**，而且知道树的**深度**的情况下，我们就可以这样对 **叶子层** 进行二分查找

            if (root == null) return 0;
            if (root.left == null) return 1;

            TreeNode leaf = root;
            int depth = 0;
            while (leaf.left != null) {
                leaf = leaf.left;
                depth++;
            }

            // 对应 深度 - 1 满二叉树 的数量，要加上叶子节点的数量
            int num = (int) Math.pow(2, depth) - 1;

            // 和Solution2的区别1
            // depth在叶子层的最右侧叶子结点的右边一个，防止该层为满的情况
            return num + binarySearch(0, (int) Math.pow(2, depth), root, depth) + 1;
        }

        private int binarySearch(int left, int right, TreeNode root, int depth) {
            // left != null && right == null
            // left就是我们要的叶子结点的最后一个
            // 和Solution2的区别2
            if (left == right - 1) {
                return left;
            }

            int mid = (left + right) / 2;
            if (findNode(mid, root, depth) == null) {
                right = mid;
            } else {
                left = mid;
            }
            return binarySearch(left, right, root, depth);
        }

        private TreeNode findNode(int bits, TreeNode root, int depth) {
            int k = 1 << (depth - 1);
            TreeNode node = root;
            // 位运算
            while (k > 0) {
                if ((bits & k) == 0) {
                    node = node.left;
                } else node = node.right;
                k = k >> 1;
            }
            return node;
        }
    }

}

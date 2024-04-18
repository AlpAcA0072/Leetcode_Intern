package leetcodeHot100.L;

public class l0141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            while (head.val != Integer.MIN_VALUE) {
                if (head.next == null) return false;
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
            return true;
        }
    }

    // 快慢指针
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;

            ListNode fast = head;
            ListNode slow = head;
            while (slow != null) {
                fast = fast.next;
                if (fast == null || fast.next == null) return false;
                fast = fast.next;
                slow = slow.next;
                if (fast == slow) return true;
            }

            return false;
        }
    }
}
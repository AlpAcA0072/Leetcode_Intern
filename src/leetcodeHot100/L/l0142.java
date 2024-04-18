package leetcodeHot100.L;

public class l0142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 不允许修改链表。
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;

            int count = 0;
            ListNode fast = head;
            ListNode slow = head;
            while (slow != null) {
                fast = fast.next;
                if (fast == null || fast.next == null) return null;
                fast = fast.next;
                slow = slow.next;
                count++;
                if (fast == slow) break;
            }

            if (slow == null) return null;

            fast = head;
            slow = head;
            for (int i = 0; i < count; i++) {
                fast = fast.next;
            }

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
    }
}

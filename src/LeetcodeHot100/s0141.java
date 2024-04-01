package LeetcodeHot100;

import java.util.HashSet;
import java.util.Set;

public class s0141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // HashMap
    // Size = O(n)
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> seen = new HashSet<ListNode>();
            while (head != null) {
                if (!seen.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }

    // 快慢指针
    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

}

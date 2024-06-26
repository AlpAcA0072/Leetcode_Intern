package suixianglu;

import ulib.ListNode;

public class s0203 {
    // recursion
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}

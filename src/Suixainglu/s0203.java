package Suixainglu;

public class s0203 {
    // recursion
    class Solution {
        public l0203.ListNode removeElements(l0203.ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}

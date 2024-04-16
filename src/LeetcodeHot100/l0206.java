package LeetcodeHot100;

import ULib.ListNode;

public class l0206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode pre = null;
            while (head != null) {
                ListNode nxt = head.next;
                head.next = pre;
                pre = head;
                head = nxt;
            }

            return pre;
        }
    }
}


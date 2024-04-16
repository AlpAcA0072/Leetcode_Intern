package Suixainglu;

import ULib.ListNode;

public class l0019 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode nxt = head;
//            if (nxt == null) return null;

            while (n > 1) {
                n--;
                nxt = nxt.next;
            }
            if (nxt.next == null) return head.next;

            ListNode prev = new ListNode();
            prev.next = head;


            while (nxt.next != null) {
                nxt = nxt.next;
                prev = prev.next;
            }

            prev.next = prev.next.next;

            return head;
        }
    }

}

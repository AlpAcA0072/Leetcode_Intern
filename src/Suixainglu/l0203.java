package Suixainglu;

public class l0203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        class Solution {
            public ListNode removeElements(ListNode head, int val) {
                if (head == null) return null;

                while (head.val == val) {
                    head = head.next;
                    if (head == null) return null;
                }

                ListNode ptr = head;
                while (true) {
                    if (ptr.next == null) return head;
                    else {
                        if (ptr.next.val == val) {
                            ptr.next = ptr.next.next;
                        } else ptr = ptr.next;
                    }
                }
            }
        }
    }
}

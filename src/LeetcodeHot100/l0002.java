package LeetcodeHot100;

public class l0002 {


    class ListNode {
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
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int mod = 0;
            ListNode head = new ListNode();
            ListNode ptr = head;
            ListNode prev = null;
            assert l1 != null && l2 != null;
            while (l1 != null && l2 != null) {
                ptr.val = (l1.val + l2.val + mod) % 10;
                mod = (l1.val + l2.val + mod) / 10;
                prev = ptr;
                ptr.next = new ListNode();
                ptr = ptr.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (l1 == null) {
                prev.next = l2;
            } else {
                prev.next = l1;
            }
            if (prev.next != null)
                ptr = prev.next;
            else if (mod != 0) {
                prev.next = new ListNode(mod);
                mod = 0;
            }


            while (mod != 0) {
                int digit = ptr.val + mod;
                ptr.val = digit % 10;
                mod = digit / 10;
                if (ptr.next != null) ptr = ptr.next;
                else if (mod != 0) {
                    ptr.next = new ListNode(mod);
                    break;
                } else break;
            }


            return head;
        }
    }

}

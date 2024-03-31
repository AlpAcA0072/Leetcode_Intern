package Suixainglu;

public class l0024 {
    public static void main(String[] args) {
        l0024 l0024 = new l0024();
        ListNode head = l0024.new ListNode(1);
        ListNode two = l0024.new ListNode(2);
        ListNode three = l0024.new ListNode(3);
        ListNode four = l0024.new ListNode(4);
        head.next = two;
        two.next = three;
        three.next = four;
        Solution solution = l0024.new Solution();
        solution.swapPairs(head);
    }
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
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;


            ListNode prev = new ListNode();
            prev.next = head;
            ListNode init = prev;

            ListNode ptr = head;
            ListNode ptrNext = ptr.next;
            while (ptrNext != null) {
                prev.next = ptrNext;
                ptr.next = ptrNext.next;
                ptrNext.next = ptr;

                prev = ptr;
                ptr = ptr.next;
                if (ptr == null) break;
                ptrNext = ptr.next;
            }

            return init.next;
        }
    }
}

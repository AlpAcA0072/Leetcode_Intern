import java.util.List;

public class l0206 {
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
}

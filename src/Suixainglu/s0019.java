package Suixainglu;

import java.util.Deque;
import java.util.LinkedList;

import ULib.ListNode;

public class s0019 {

    // length of the linked list = L
    // Time: O(L), Space: O(L)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            Deque<ListNode> stack = new LinkedList<ListNode>();
            ListNode cur = dummy;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            for (int i = 0; i < n; ++i) {
                stack.pop();
            }
            ListNode prev = stack.peek();
            prev.next = prev.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }

    // 双指针
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode first = head;
            ListNode second = dummy;
            for (int i = 0; i < n; ++i) {
                first = first.next;
            }
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            ListNode ans = dummy.next;
            return ans;
        }
    }
}

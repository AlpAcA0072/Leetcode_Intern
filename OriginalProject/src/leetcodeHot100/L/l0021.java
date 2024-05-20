package leetcodeHot100.L;

import ulib.ListNode;

public class l0021 {


    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            else if (list2 == null) return list1;

            if (list1.val > list2.val) {
                ListNode temp = list1;
                list1 = list2;
                list2 = temp;
            }

            ListNode head = list1;

            while (list2 != null) {
                if (list1.next != null && list1.next.val > list2.val) {
                    ListNode temp = new ListNode(list2.val);
                    list2 = list2.next;
                    temp.next = list1.next;
                    list1.next = temp;
                    list1 = list1.next;
                } else if (list1.next != null) {
                    list1 = list1.next;
                } else {
                    list1.next = list2;
                    break;
                }
            }

            return head;
        }
    }

    // recursion
    class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            else if (list2 == null) return list1;
            else if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
}

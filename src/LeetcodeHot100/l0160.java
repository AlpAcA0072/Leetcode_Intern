package LeetcodeHot100;

import UsefulLib.ListNode;

public class l0160 {

    // length of A: m, length of B: n
    // time: O(2 * max(m, n)), space: O(1)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            int lenA = 0, lenB = 0;
            ListNode tempA = headA, tempB = headB;
            while (tempA != null) {
                lenA++;
                tempA = tempA.next;
            }

            while (tempB != null) {
                lenB++;
                tempB = tempB.next;
            }

            if (lenA > lenB) {
                int temp = lenA;
                lenA = lenB;
                lenB = temp;

                ListNode tempNode = headA;
                headA = headB;
                headB = tempNode;
            }

            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }

            while (headA != null && headB != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }

            if (headA == headB) return headA;
            else return null;
        }
    }

    // length of A: m, length of B: n
    // time: O(m + n), space: O(1)
    // 注意solution2和solution3的区别
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode currA = headA, currB = headB;
            while (currA != currB) {
//                if (currA == null) currA = headB;
//                if (currB == null) currB = headA;
//                currA = currA.next;
//                currB = currB.next;
                if (currA == null) currA = headB;
                else currA = currA.next;
                if (currB == null) currB = headA;
                else currB = currB.next;
            }

            return currA;
        }
    }


    // 注意solution3和solution4的区别

    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode currA = headA, currB = headB;
            while (currA != currB) {
                if (currA == null) currA = headB;
                if (currB == null) currB = headA;
                // This line is critical. 否则会跳过tail的比较
                if (currA == currB) break;
                currA = currA.next;
                currB = currB.next;
            }

            return currA;
        }
    }

    public class Solution4 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;

            ListNode currA = headA, currB = headB;
            while (currA != currB) {
                currA = currA.next;
                currB = currB.next;
                // This line is critical. 否则会跳过tail.next的比较
                if (currA == null && currB == null) break;
                if (currA == null) currA = headB;
                if (currB == null) currB = headA;
            }

            return currA;
        }
    }
}

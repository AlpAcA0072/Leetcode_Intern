package suixianglu;

import ulib.ListNode;

import java.util.*;

public class l0023 {
    public static void main(String[] args) {
        l0023 l = new l0023();
        Solution s = l.new Solution();
        Solution2 s2 = l.new Solution2();
        ListNode[] listNodes = new ListNode[3];
        ListNode l12 = new ListNode(4);
        l12.next = new ListNode(5);
        listNodes[0] = new ListNode(1, l12);

        ListNode l22 = new ListNode(3);
        l22.next = new ListNode(4);
        listNodes[1] = new ListNode(1, l22);

        ListNode l32 = new ListNode(6);
        listNodes[2] = new ListNode(2, l32);
//        s.mergeKLists(listNodes);
        s2.mergeKLists(new ListNode[]{});
        ListNode result = s2.mergeKLists(listNodes);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // 每次都排序，不对
    // [[1,4,5],[1,3,4],[2,6]]
    // 结果是[1,1,2,3,4,6,4,5]
    // 但是应该是[1,1,2,3,4,4,5,6]
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result_prev = new ListNode(-1, null);
            ListNode ptr_prev = result_prev;
            ArrayList<ListNode> temp = new ArrayList<>(List.of(lists));

            while (!temp.isEmpty()) {
                temp.sort(Comparator.comparingInt(o -> o.val));
                ArrayList<ListNode> to_remove = new ArrayList<>();
                for (int i = 0; i < temp.size(); i++) {
                    ptr_prev.next = temp.get(i);
                    ptr_prev = ptr_prev.next;
                    if (temp.get(i).next == null) {
                        to_remove.add(temp.get(i));
                    } else temp.set(i, temp.get(i).next);
                }
                for (int i = to_remove.size() - 1; i >= 0; i--) {
                    temp.remove(to_remove.get(i));
                }
            }

            return result_prev.next;
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result_prev = new ListNode(-1, null);
            ListNode ptr_prev = result_prev;

            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }
            while (!pq.isEmpty()) {
                ListNode temp = pq.poll();
                ptr_prev.next = temp;
                ptr_prev = ptr_prev.next;
                temp = temp.next;
                if (temp != null) {
                    pq.add(temp);
                }
            }
            return result_prev.next;
        }
    }

}

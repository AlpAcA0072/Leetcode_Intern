package Suixainglu;

public class l0707 {
    // 边界情况非常多，慎重考虑
    public static void main(String[] args) {
        l0707 l0707 = new l0707();
        MyLinkedList linkedList = l0707.new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(7);
        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtHead(5);
        linkedList.addAtTail(5);
        System.out.println(linkedList.get(5));
        linkedList.deleteAtIndex(6);
        linkedList.deleteAtIndex(4);

//        linkedList.addAtIndex(1, 2);
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1);
//        System.out.println(linkedList.get(1));
    }

    /**
     * MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    class MyLinkedList {
        private int size;
        private final ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(Integer.MIN_VALUE);
        }

        public int get(int index) {
            ListNode ptr = head;
            while (index >= 0) {
                ptr = ptr.next;
                if (ptr == null) return -1;
                index--;
            }
            return ptr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            index = Math.max(0, index);
            ListNode prev = head;
            ListNode ptr = head.next;
            while (index > 0) {
                prev = ptr;
                ptr = ptr.next;
                index--;
            }
            ListNode inserted = new ListNode(val);
            prev.next = inserted;
            inserted.next = ptr;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            ListNode ptr = head.next;
            ListNode prev = head;
            while (index > 0) {
                prev = ptr;
                ptr = ptr.next;
                index--;
            }
            prev.next = ptr.next;
            size--;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }
    }
}

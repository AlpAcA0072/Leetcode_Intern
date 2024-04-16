package suixianglu;

import java.util.LinkedList;
import java.util.Queue;

public class l0225 {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    class MyStack {
        Queue<Integer> inQ, stack;


        public MyStack() {
            inQ = new LinkedList<>();
            stack = new LinkedList<>();
        }

        public void push(int x) {
            inQ.add(x);
            while (!stack.isEmpty()) {
                inQ.add(stack.remove());
            }
            Queue<Integer> temp = inQ;
            inQ = stack;
            stack = temp;
        }

        public int pop() {
            return stack.remove();
        }

        public int top() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}

package Suixainglu;

import java.util.Stack;

public class l0232 {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    class MyQueue {
        Stack<Integer> inStack, outStack;


        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        private void dump() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.empty()) {
                dump();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.empty()) {
                dump();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }
    }


}

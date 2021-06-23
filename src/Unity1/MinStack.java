package Unity1;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> min = new Stack();
    /** initialize your data structure here. */
    public MinStack() {
        min.push(Integer.MAX_VALUE);// 预先存放最大值
    }

    public void push(int val) {
        stack.push(val); // 将值存入栈
        min.push(Math.min(val,min.peek()));// 将最小值存入最小栈
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

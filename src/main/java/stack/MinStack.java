package stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> s1 = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
        s1.push(x);
    }

    public void pop() {
       s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        int min=0;
        while (s1.size()!=0){
            int top=s1.pop();
            if (min<top){
                min=top;
            }
        }
      return min;

    }
}

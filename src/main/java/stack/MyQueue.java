package stack;

import java.util.Stack;

public class MyQueue {
    MyQueue myQueue=new MyQueue();
    /** Initialize your data structure here. */
    public MyQueue() {


    }

    Stack stack1=new Stack();
    Stack stack2=new Stack();

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);


    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp=0;
        if (stack2.isEmpty()){
            while (stack1.size()!=0){
                int top= (int) stack1.pop();
                stack2.push(top);
            }
            temp= (int) stack2.pop();
        }else {
            temp= (int) stack2.pop();
        }

        return temp;

    }

    /** Get the front element. */
    public int peek() {
        int temp=0;
        if (stack2.isEmpty()){
            while (stack1.size()!=0){
                int top= (int) stack1.pop();
                stack2.push(top);
            }
            temp= (int) stack2.peek();
        }else {
            temp= (int) stack2.peek();
        }

        return temp;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack1.size()==0&&stack2.size()==0){
            return true;
        }
        return false;
    }
}

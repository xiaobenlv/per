package stack;


import java.util.LinkedList;


public class MyStack {

    LinkedList<Integer> linkedList1=new LinkedList<Integer>();
    LinkedList<Integer> linkedList2=new LinkedList<Integer>();
    int top;

    /** Initialize your data structure here. */
    public MyStack() {

    }

//    ？？？？
    /** Push element x onto stack. */
    public void push(int x) {
        linkedList1.push(x);
        if (!linkedList1.isEmpty()){
            while (linkedList1.size()>1){
                int top= linkedList1.pop();
                linkedList2.push(top);
                if (linkedList1.size()==1){
                    break;
                }
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        if (!linkedList1.isEmpty()){
            return linkedList1.pop();
        }
        return -1;


    }

    /** Get the top element. */
    public int top() {
        if (!linkedList1.isEmpty()){
            return linkedList1.peek();
        }
        return -1;



    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (linkedList1.size()==0&&linkedList2.size()==0){
            return true;
        }else {
            return false;
        }

    }

}

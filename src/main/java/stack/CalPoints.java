package stack;

import java.util.Stack;


public class CalPoints {
    public int calPoints(String[] ops) {

        Stack stack=new Stack();
        int total=0;
        for (String s:ops){
//            如果是整数
            if (s.equals("C")){
//             如果是C，出栈 然后计算分数
                if (!stack.isEmpty()){
                    if (!stack.isEmpty()){
                        int top= (int) Integer.parseInt(String.valueOf(stack.pop()));
                        total=total-top;
                    }

                }
            }else if (s.equals("D")){
                if (!stack.isEmpty()){
                    int top1=(int) Integer.parseInt(String.valueOf(stack.pop()));
                    int thistime=top1+top1;
                    stack.push(thistime);
                    total+=thistime;
                }

            }else if (s.equals("+")){
                if (stack.size()>=2){
                    int top1=(int) Integer.parseInt(String.valueOf(stack.pop()));
                    int top2=(int) Integer.parseInt(String.valueOf(stack.pop()));
                    int thistime1=top1+top2;
                    stack.push(top1);
                    stack.push(thistime1);
                    total+=thistime1;
                }
            }else {
                stack.push(s);
                total+=Integer.parseInt(String.valueOf(s));
            }
        }

        return total;
    }

    public static void main(String[] args) {
        CalPoints calPoints=new CalPoints();
        String[] ops= new String[]{"5","-2","4","C","D","9","+","+"};
        int total=calPoints.calPoints(ops);
        System.out.println(total);
    }
// 区分stack.pop 和stack.peek
    public int fun(String[] ops) {
        int n = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "+":
                    //stack.pop()删除堆栈顶部的对象并返回该对象
                    int del = stack.pop();
                    //stack.peek()返回堆栈顶部的对象
                    int last = del + stack.peek();
                    n += last;
                    stack.push(del);
                    stack.push(last);
                    break;
                case "D":
                    int twoLast = stack.peek() * 2;
                    n += twoLast;
                    //stack.push(twoLast)保存到堆栈
                    stack.push(twoLast);
                    break;
                case "C":
                    n -= stack.pop();
                    break;
                default:
                    int save = Integer.parseInt(s);
                    n += save;
                    stack.push(save);
                    break;
            }
        }
        return n;
    }



}

package stack;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] arrays=S.toCharArray();
        char[] arrayt=T.toCharArray();
        Stack<Character> stack1=new Stack<Character>();
        Stack<Character> stack2=new Stack<Character>();
        for (Character c:arrays){
            if (c!='#'){
                stack1.push(c);
            }else {
                if (!stack1.isEmpty()){
                    stack1.pop();
                }

            }
        }
        for (Character c:arrayt){
            if (c!='#'){
                stack2.push(c);
            }else {
                if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }
        }
        if (stack1.size()!=stack2.size()){
            return false;

        }
        while (stack1.size()!=0){
            if (stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        return true;
    }


//    1.涉及到基本类型之间的拆箱、装箱，是自动的 即int \Integer 之间，然后char 和Character之间


//    1.八种基本类型  int、short、long、double、float（存储时分为小数点和 之前之后的分别存储）、byte、char、boolean

//    装箱：基本类型变成包装类型，可以手动装箱，也可自动装箱  拆箱：把包装类转换成基本类型的值

//    注意：String不是基本类型 是字符数组；
//    4.基本类型和字符串之间的转换   （1）.tostring   String.valueof(c) 等   string变成包装类：1. 调用包装类的 parseXxx 静态方法
//
//2. 调用包装类的 valueOf() 方法转换为基本类型的包装类，会自动拆箱

//https://www.cnblogs.com/huangxin1118/p/5716575.html

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare=new BackspaceCompare();
        String s="a#c";
        String t="b";
        boolean b=backspaceCompare.backspaceCompare(s,t);
        System.out.println(b);
    }


}

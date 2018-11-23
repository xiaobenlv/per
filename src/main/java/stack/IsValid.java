package stack;

import java.util.Stack;

public class IsValid {
    public boolean isValid(String s) {

        Stack st=new Stack();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c=='('||c=='{'||c=='['){
                st.push(c);
            }
            if (c==')'){
                if (!st.isEmpty()){
                   char top= (char) st.pop();
                   if (top!='('){
                       return false;
                   }
                }
                else {
                    return false;
                }
            }
            else if (c=='}'){
                if (!st.isEmpty()){
                    char top= (char) st.pop();
                    if (top!='{'){
                        return false;
                    }
                }else {
                    return false;
                }
            }
            else if (c==']'){
                if (!st.isEmpty()){
                    char top= (char) st.pop();
                    if (top!='['){
                        return false;
                    }
                }else {
                    return false;
                }
            }

        }
        if (!st.isEmpty()){
            return false;
        }
        return true;


    }

    public static void main(String[] args) {
        String s="]";
        IsValid isValid=new IsValid();
        boolean b=isValid.isValid(s);
        System.out.println(b);
    }


}

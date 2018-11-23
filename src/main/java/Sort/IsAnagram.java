package Sort;

import java.util.Arrays;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        char[] chars=s.toCharArray();
        char[] chars1=t.toCharArray();
        int length1=chars.length;
        int length2=chars1.length;
        if (length1!=length2){
            return false;
        }
        Arrays.sort(chars);
        Arrays.sort(chars1);
        int i=0;int j=0;
        while (i<length1){
            if (chars[i]!=chars1[j]){
                return false;
            }
            i++;
            j++;

        }


        return true;

    }

    public static void main(String[] args) {

        String s="rat";
        String t="car";



        boolean b=IsAnagram.isAnagram(s,t);
        System.out.println(b);

    }
}

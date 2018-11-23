package tanxin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
//  同时遍历 两个数组
        while (i<g.length&&j<s.length){
            if (g[i]<=s[j]){
                i++;
                j++;

            }else {
                j++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] g={1,2};
        int[] s={1,2,3};
        FindContentChildren findContentChildren=new FindContentChildren();
        int i=findContentChildren.findContentChildren(g,s);
        System.out.println(i);

    }

}

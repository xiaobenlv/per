package stack;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums1.length;i++) {
            for (int j=0;j<nums2.length;j++) {
                int flag=0;
                if (nums1[i]==nums2[j]) {
                    int length=list.size();
                    for (int k = j+1; k < nums2.length; k++) {
                        if (nums1[i]<nums2[k]){
                            list.add(nums2[k]);
                            flag=1;
                            break;
                        }
                    }
                    int length1=list.size();
                    if (length1==length){
                        list.add(-1);
                        break;
                    }
                }
//                增加一个flag，跳出判断完的那层循环，减少循环次数
                if (flag==1){
                    break;
                }
            }
        }
        Integer[] ints=list.toArray(new Integer[list.size()]);
        int a=ints.length;
        int[] ints1=new int[a];
        for (int integer=0;integer<a;integer++){
            ints1[integer]=ints[integer].intValue();
        }
        return ints1;
    }

    public static void main(String[] args) {
        int[] ints={4,1,2};
        int[] ints1={1,3,4,2};
        NextGreaterElement nextGreaterElement=new NextGreaterElement();
        int[] a=nextGreaterElement.nextGreaterElement(ints,ints1);
        for (int i:a){
            System.out.println(i);
        }
    }
}

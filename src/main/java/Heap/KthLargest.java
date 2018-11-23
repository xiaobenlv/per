package Heap;

import java.util.*;

public class KthLargest {
    List<Integer> list;
    int kt;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        kt=k;
    }
    public int add(int val) {
        if(list.size()==0||val>=list.get(list.size()-1))
            list.add(val);
        else{
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i)>val)
                {
                    list.add(i,val);
                    break;
                }
            }
        }
        return list.get(list.size()-kt);
    }

    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        KthLargest kthLargest=new KthLargest(3,arr);

        System.out.println(kthLargest.add(3));

    }


}

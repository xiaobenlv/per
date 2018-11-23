package Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
//        List list1=new ArrayList();
//        List list2=new ArrayList();
//        for (int i:nums1){
//            list1.add(i);
//        }
//        for (int j:nums2){
//            list2.add(j);
//        }
//       list1.retainAll(list2);
////       注意此句转换 list转换成数组,list.toArray 生成的是object类型的，不能够向下转型变成 String Integer等，object是包装类
//       Integer[] integers= (Integer[]) list1.toArray(new Integer[list1.size()]);
////   将
//        int[] ints=new int[integers.length];
//        for (int i=0;i<integers.length;i++){
//
//            ints[i]=integers[i];
//        }
//        return ints;


//    不重复就考虑利用set存储,在set初始化的时候就考虑 类型就不会出现类型的问题了，所以 一定要在new的时候写好类型转换

        Set<Integer> set1=new HashSet();
        Set<Integer> set2=new HashSet();

        for (int i:nums1){
            set1.add(i);
        }
        for (int j:nums2){
            if (set1.contains(j)){
                set2.add(j);
            }
        }

        int[] ints=new int[set2.size()];
        int k=0;

        for (int i:set2){
            ints[k++]=i;

        }
        return ints;
    }


    public int[] intersection1(int[] nums1, int[] nums2) {

        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer>  list2=new ArrayList<>();
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]==nums2[j]){
                    if (list1.contains(i)){
                        break;
                    }else {
                        if (list2.contains(j)){
                            continue;
                        }
                        list1.add(i);
                        list2.add(j);
                        list.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        int k=0;
        int[] ints=new int[list.size()];
        for (Integer integer:list){
            ints[k++]=integer;
        }

        return ints;
    }


    public static void main(String[] args) {
        int nums1[]={1,2,2,1};
        int nums2[]={1,2};
        Intersection intersection=new Intersection();
        int[] a=intersection.intersection1(nums1,nums2);
        for (int i:a){
            System.out.println(i);
        }

    }
}
